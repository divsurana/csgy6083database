/**
 * 
 */
package org.nyu.csgy6083database.service;

import java.util.List;

import org.nyu.csgy6083database.model.Followers;
import org.nyu.csgy6083database.repository.FollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author divyeshsurana
 *
 */
@Service("followersService")
public class FollowersServiceImpl implements FollowersService {

	@Autowired
	private FollowersRepository followersRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nyu.csgy6083database.service.Service#save(java.lang.Object)
	 */
	@Override
	@Transactional
	public Followers save(Followers follower) {
		return followersRepository.save(follower);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Followers> getFollowers(String username) {
		return followersRepository.findFollowers(username);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Followers> getFollowed(String username) {
		return followersRepository.findFollowed(username);
	}

}
