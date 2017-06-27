package com.dao;

import com.bean.LoginBean;
import com.entity.User;

public interface DataAccessService {

	public boolean Authenticate(LoginBean bean);
	
	public void saveUser(User user);
}
