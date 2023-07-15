package utp.integrador.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.integrador.avance.dao.*;
import utp.integrador.avance.model.*;
import utp.integrador.avance.service.ParameterService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    private ParameterEspecialidadRepository especialidadRepository;

    @Autowired
    private ParameterTituloRepository tituloRepository;

    @Autowired
    private PuestoRepository repository;

    @Autowired
    private EspecialidadRepository espRepository;

    @Autowired
    private TituloRepository titRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DatosPersonalesRepository datosPersonalesRepository;

    @Autowired
    private EstProfesionRepository profesionRepository;

    @Autowired
    private ExpLaboralRepository laboralRepository;

    @Override
    public List<Puesto_Docente> listPuestos() {
        return repository.findAll();
    }

    @Override
    public Puesto_Docente findOne(Integer id) {
        return Optional.of(repository.findById(id)).get().orElse(new Puesto_Docente());
    }

    @Override
    public List<Parameter_Especialidad> listEspecialidadById(Integer id) {
        return especialidadRepository.findAllByPuestoDocenteId(id);
    }

    @Override
    public List<Parameter_Titulo> listTituloById(Integer id) {
        return tituloRepository.findAllByPuestoDocenteId(id);
    }

    @Override
    public Puesto_Docente savePuesto(Puesto_Docente puestoDocente) {
        return repository.save(puestoDocente);
    }

    @Override
    public List<Especialidad> listEspecialidad() {
        return espRepository.findAll();
    }

    @Override
    public List<Titulo> listTitulo() {
        return titRepository.findAll();
    }

    @Override
    public Parameter_Especialidad saveParamEsp(Parameter_Especialidad especialidad, Integer id) {
        Long n = (long) (especialidadRepository.findAllByPuestoDocenteId(id).size() + 1);
        Puesto_Docente puesto = findOne(id);
        especialidad.setId(n);
        especialidad.setPuestoDocente(puesto);
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Parameter_Titulo saveParamTit(Parameter_Titulo titulo, Integer id) {
        Long n = (long) (tituloRepository.findAllByPuestoDocenteId(id).size() + 1);
        Puesto_Docente puesto = findOne(id);
        titulo.setId(n);
        titulo.setPuestoDocente(puesto);
        return tituloRepository.save(titulo);
    }

    @Override
    public List<UserPuntaje> getAllUsers(Integer id) {
        //MULTIPLICADORES POR TITULO
        List<Parameter_Titulo> titPuntaje = tituloRepository.findAllByPuestoDocenteId(id);
        //MULTIPLICADORES POR ESPECIALIDAD
        List<Parameter_Especialidad> espPuntaje = especialidadRepository.findAllByPuestoDocenteId(id);
        //OBTENER USUARIOS
        List<User> usuarios = userRepository.findAll();
        List<UserPuntaje> userPuntaje = new ArrayList<>();
        for (int i = 0; i<usuarios.size(); i++) {
            UserPuntaje u = new UserPuntaje();
            //OBTENIENDO VALORES
            System.out.println("1---->"+usuarios.size());
            System.out.println("2---->"+usuarios.get(i).getUserId());
            System.out.println("3---->"+Math.toIntExact(usuarios.get(i).getUserId()));
            System.out.println("4---->"+usuarios.get(i).getEmail());
            Datos_Personales d = datosPersonalesRepository.findByUserEmail(usuarios.get(i).getEmail());
            List<Estudio> estudios = profesionRepository.findAllByUserEmail(usuarios.get(i).getEmail())
                    .stream()
                    .map(Est_Profesional::getEstudio)
                    .toList();
            List<Titulo> titulos = estudios.stream().map(Estudio::getTitulo).toList();
            List<Especialidad> especialidads = estudios.stream().map(Estudio::getEspecialidad).toList();
            //CALCULAR NOMBRE
            u.setName(d.getPaterno() + " " + d.getMaterno() + " " + d.getNombres());
            //CALCULAR PUNTAJE Titulo
            Double puntajeTotal = 0.0;
            for (int j = 0; j < titPuntaje.size(); j++) {
                if (titulos.contains(titPuntaje.get(j).getTitulo())) {
                    Parameter_Titulo tPuntaje = titPuntaje.get(j);
                    puntajeTotal = puntajeTotal + tPuntaje.getPuntaje();
                } else {
                    puntajeTotal = puntajeTotal + 1;
                }
            }
            //CALCULAR PUNTAJE Especialidad
            for (int j = 0; j < espPuntaje.size(); j++) {
                if (especialidads.contains(espPuntaje.get(j).getEspecialidad())) {
                    Parameter_Especialidad tPuntaje = espPuntaje.get(j);
                    puntajeTotal = puntajeTotal + tPuntaje.getPuntaje();
                } else {
                    puntajeTotal = puntajeTotal + 1;
                }
            }
            u.setPuntaje(puntajeTotal);
            u.setUser(usuarios.get(i));
            userPuntaje.add(u);
        }

        //ORDENAR DE MENOR A MAYOR
        Collections.sort(userPuntaje, (o1, o2) -> (int) (o2.getPuntaje() - o1.getPuntaje()));
        return userPuntaje;
    }
}
