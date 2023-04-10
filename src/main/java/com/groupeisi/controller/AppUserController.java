package com.groupeisi.controller;

import com.groupeisi.entity.ProfessorEntity;
import com.groupeisi.service.AppUserService;
import com.groupeisi.entity.AppUserEntity;
import com.groupeisi.entity.StudentEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppUserController {
    private AppUserService userService;
    public  AppUserController(AppUserService userService){
        this.userService = userService;
    }

    // S T U D E N T S  -----------------------------------------------------------------
    @GetMapping("/students")
    public List<StudentEntity> getStudents(){
        return this.userService.getStudents();
    }

    @PostMapping("/students")
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentEntity addStudent(@Valid @RequestBody StudentEntity student){
        try {
            return this.userService.addStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // P R O F E S S O R S ----------------------------------------------------------------
    @GetMapping("/profs")
    public List<ProfessorEntity> getProfessors(){
        return this.userService.getProfessors();
    }

    @PostMapping("/profs")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProfessorEntity addProfessor(@Valid @RequestBody ProfessorEntity professor){
        try {
            return this.userService.addProfessor(professor);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // A L L   U S E R S ----------------------------------------------------------------
    @GetMapping("/users")
    public List<AppUserEntity> getUsers(){
        return this.userService.getAllUsers();
    }
}
