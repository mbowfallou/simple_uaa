package com.groupeisi.service;

import com.groupeisi.entity.AppRoleEntity;
import com.groupeisi.entity.AppUserEntity;
import com.groupeisi.entity.ProfessorEntity;
import com.groupeisi.entity.StudentEntity;
import com.groupeisi.repository.IAppRoleRepository;
import com.groupeisi.repository.IAppUserRepository;
import com.groupeisi.repository.IProfessorRepository;
import com.groupeisi.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserService {
    private IAppUserRepository userRepository;
    private IAppRoleRepository roleRepository;
    private IStudentRepository studentRepository;
    private IProfessorRepository professorRepository;
    public AppUserService(IAppUserRepository userRepository,
                          IAppRoleRepository roleRepository,
                          IProfessorRepository professorRepository,
                          IStudentRepository studentRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
    }

    // Get Students
    public List<StudentEntity> getStudents(){
        return this.studentRepository.findAll();
        //.stream().collect(Collectors.toList());
    }

    // Add a Student
    public StudentEntity addStudent(StudentEntity student){
        //student.addRole(roleRepository.findByName("STUDENT"));
        if(userRepository.findByEmailIgnoreCase(student.getEmail()).isPresent()
                || userRepository.findByUsernameIgnoreCase(student.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Les noms d'utilisateur et email sont uniques !");
        }
        return this.studentRepository.save(student);
    }

    // Get Professors
    public List<ProfessorEntity> getProfessors(){
        return this.professorRepository.findAll();
        //.stream().collect(Collectors.toList());
    }

    // Add a Professor
    public ProfessorEntity addProfessor(ProfessorEntity professor){
        //professor.addRole(roleRepository.findByName("STUDENT"));
        if(userRepository.findByEmailIgnoreCase(professor.getEmail()).isPresent()
                || userRepository.findByUsernameIgnoreCase(professor.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Les noms d'utilisateur et email sont uniques !");
        }
        return this.professorRepository.save(professor);
    }

    // Get All Users
    public List<AppUserEntity> getAllUsers(){
        return this.userRepository.findAll();
        //.stream().collect(Collectors.toList());
    }

    // Init Roles if empty
    @PostConstruct
    public void initRoles(){
        if(roleRepository.findAll().isEmpty()){
            roleRepository.save(new AppRoleEntity(null, "STUDENT"));
            roleRepository.save(new AppRoleEntity(null, "PROFESSOR"));
        }
    }
}
