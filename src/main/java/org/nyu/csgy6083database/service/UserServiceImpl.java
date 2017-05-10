package org.nyu.csgy6083database.service;

import java.util.List;

import org.nyu.csgy6083database.model.User;
import org.nyu.csgy6083database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean findByLogin(String userName, String password) {

		User user = userRepository.findByUserName(userName);

		return user != null && user.getPassword().equals(password);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findByName(String name) {
		return userRepository.findByName("%" + name + "%");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.nyu.csgy6083database.service.UserService#findByUserName(java.lang.
	 * String)
	 */
	@Override
	@Transactional(readOnly = true)
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nyu.csgy6083database.service.UserService#isUserExists(java.lang.
	 * String)
	 */
	@Override
	@Transactional(readOnly = true)
	public boolean isUserExists(String userName) {
		return userRepository.findByUserName(userName) != null;
	}

}