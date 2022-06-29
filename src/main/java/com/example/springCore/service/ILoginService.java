package com.example.springCore.service;

import java.util.Optional;

import com.example.springCore.entity.Login;

import antlr.collections.List;

/*import antlr.collections.List;*/

public interface ILoginService {
	
	Login login(Login credentials);

	Login addLogin(Login login);

	Optional<Login> deleteLogin(String email);

	Optional<Login> getLogin(String email);

	List getAllLogin();
	
	/*package com.example.spring.service;

	import com.example.spring.entity.Login;

	public interface ILoginService {

		Login login(Login credentials);*/

	}
