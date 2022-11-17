/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.dpe.siigpe.ca.service;

import java.util.List;
import java.util.Optional;
import mg.dpe.siigpe.ca.model.SiigpeRole;
import mg.dpe.siigpe.ca.model.SiigpeUser;
import mg.dpe.siigpe.ca.repository.SiigpeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author BasilisseN
 */
@Service
@Transactional(readOnly = true)
public class SiigpeUserServiceImpl implements SiigpeUserService {

    /*@Autowired
    PasswordEncoder passwordEncoder;*/
    @Autowired
    SiigpeUserRepository repository;

    @Override
    public Optional<SiigpeUser> findById(short id) {
        return repository.findById(id);
    }

    @Override
    public SiigpeUser findByUsername(String username) {
        return repository.findByUserName(username);
    }

    @Override
    public List<SiigpeUser> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public SiigpeUser save(SiigpeUser user) {
        //user.setUserPass(passwordEncoder.encode(user.getUserPass()));
        return repository.save(user);
    }

    /*@Override
    public SiigpeUser addUsername(SiigpeUser user) {
        return repository.save(user)
    }*/
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(SiigpeUser user) {
        repository.delete(user);
        // throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteById(short id) {
        repository.deleteById(id);
    }

    /*@Override
    public SiigpeUser findByUserId(Short id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return repository.findByUserId(id);
    }
*/
    @Override
    public List<SiigpeUser> findByUserId(Short users) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return repository.findByUserId(users);
    }

}
