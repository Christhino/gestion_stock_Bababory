/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.dpe.siigpe.ca.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mg.dpe.siigpe.ca.model.SiigpeRole;
import mg.dpe.siigpe.ca.model.SiigpeUser;
import mg.dpe.siigpe.ca.service.SiigpeRoleService;
import mg.dpe.siigpe.ca.service.SiigpeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    SiigpeUserService userService;

    @Autowired
    SiigpeRoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    //lister
    //@GetMapping("/getUsers") 
    @RequestMapping(value = "/getUsers", method = RequestMethod.POST)
    public ResponseEntity<?> getAllUser() {
        System.out.print("heloo" + userService.findAll());
        //List<SiigpeRole> siigpeRoleList = new ArrayList<>();

        //roleService.findAll();
        return ResponseEntity.ok(userService.findAll());
    }

    //ajouter
    @PostMapping("/addUser")
    public ResponseEntity<?> addUsername(HttpServletRequest request, HttpServletResponse response) {
        //System.out.println("Add USER : " + request.getParameter("userLogin"));
        SiigpeUser user = new SiigpeUser(null, request.getParameter("userLogin"), passwordEncoder.encode(request.getParameter("motDePasse")));
        String[] roles = request.getParameterValues("roles");
        List<SiigpeRole> siigpeRoleList = new ArrayList<>();
        for (String roleLib : roles) {
            System.out.println("Role [] :" + roleLib);
            siigpeRoleList.add(roleService.findByRoleLib(roleLib));
        }
        user.setSiigpeRoleList(siigpeRoleList);
        userService.save(user);
        return ResponseEntity.ok(null);
    }
    //delete
    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(HttpServletRequest request, HttpServletResponse response) {
        Short userId = Short.valueOf(request.getParameter("userId"));
        /*SiigpeUser user = userService.findById(userId).get();
        if (user != null){
            userService.delete(user);
        }*/
        userService.deleteById(userId);
        return ResponseEntity.ok(null);
    }
    @GetMapping("/getUserId/{id}")
    public ResponseEntity<List<SiigpeUser>> getUserId(@PathVariable(value = "id") short id ,HttpServletRequest request){
    
           return ResponseEntity.ok(userService.findByUserId(id));
    }
    
    //update
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Short id,@RequestBody SiigpeUser userDetails){
        System.out.println(id);
      /*  SiigpeUser user = userService.findById(id)
                .orElseThrow(() -> new ResourceNotException("UserId n'existe pas :" + id));
        user.setUserId(userDetails.getUserId());
        user.setUserName(userDetails.getUserName());
        user.setUserPass(userDetails.getUserPass());
        
        SiigpeUser updateUser = userService.save(user);
        return ResponseEntity.ok(updateUser);*/
      return null;
     }
    
   // @GetMapping ()
    
    /*
    //delete
   @DeleteMapping("/Users/{id}")
   public ResponseEntity<Map<String , Boolean >> deleteUser(@PathVariable Short id){
       SiigpeUser user = service.findById(id)
                .orElseThrow(() -> new ResourceNotException("UserId n'existe pas :" + id));
        service.delete(user);
        Map<String , Boolean> response = new HashMap<>();
        response.put("delete", Boolean.FALSE);
        return ResponseEntity.ok(response);
   }
   
         */
    }
