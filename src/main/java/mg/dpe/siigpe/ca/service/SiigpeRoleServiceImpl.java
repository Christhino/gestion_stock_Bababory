package mg.dpe.siigpe.ca.service;

import java.util.List;
import java.util.Optional;
import mg.dpe.siigpe.ca.model.SiigpeRole;
import mg.dpe.siigpe.ca.repository.SiigpeRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class SiigpeRoleServiceImpl implements SiigpeRoleService{
    
    @Autowired
    SiigpeRoleRepository repository;

    @Override
    public Optional<SiigpeRole> findById(short id) {
        return repository.findById(id);
    }

    @Override
    public SiigpeRole findByRoleLib(String roleLib) {
        return repository.findByRoleLib(roleLib);
    }
    
    
    @Override
    public List<SiigpeRole> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public SiigpeRole save(SiigpeRole role) {
        return repository.save(role);
    }    


    @Override
    public void delete(SiigpeRole role) {
        repository.delete(role);
        repository.delete(role);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public SiigpeRole findByRoleId(short id) {
        return repository.findByRoleId(id);
    }

    @Override
    public void deleteById(short id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SiigpeRole> findByRoleId(Short roles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}