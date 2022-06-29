package com.example.springCore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springCore.entity.Login;
import com.example.springCore.exception.InvalidCredentialsException;
import com.example.springCore.repository.ILoginRepository;

import antlr.collections.List;

@Service
public class LoginServiceImpl implements ILoginService{
	
	@Autowired
	ILoginRepository loginRepo;

	/*@Override
	public List<Login> getAllLogin(){
		return loginRepo.findAll();
	}
	@Override
	public Optional<Login> getLogin(String email){
		return loginRepo.findById(email);
	}
	
	public Login addLogin(Login login) {
		return loginRepo.save(login);
	}
	@Override
	public Optional<Login> deleteLogin(String email){
		try {
			Optional<Login> loginData = loginRepo.findById(email);
            if (loginData != null) {
                loginRepo.deleteById(email);
                return loginData;
            } else {
                throw new InvalidCredentialsException("login Data not found");
            }
        } catch (Exception e) {
            return null;
        }
    }*/
	@Override
	public Login login(Login credentials) {;//email,password
	
	//get login details from db
	Optional<Login> dbLoginCred= loginRepo.findById(credentials.getEmail());
	
	if(dbLoginCred.isPresent()) {
		//compare db password with user provided password
		//if password matching return credentials else throw exception
		if(dbLoginCred.get().getPassword().equals(credentials.getPassword())) {
			return credentials;
		}else {
			throw new InvalidCredentialsException("Invalid password");
		}
	}else {
		//throw exception if given email not present in the db.
		throw new InvalidCredentialsException("Invalid credentials");
	    }
	
	}
		

	@Override
	public Login addLogin(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Login> deleteLogin(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Login> getLogin(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAllLogin() {
		// TODO Auto-generated method stub
		return null;
	}
}
