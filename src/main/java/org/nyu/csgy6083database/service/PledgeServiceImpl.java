/**
 * 
 */
package org.nyu.csgy6083database.service;

import org.nyu.csgy6083database.model.Pledge;
import org.nyu.csgy6083database.repository.PledgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author divyeshsurana
 *
 */
@Service("pledgeService")
public class PledgeServiceImpl implements PledgeService {

	@Autowired
	private PledgeRepository pledgeRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nyu.csgy6083database.service.Service#save(java.lang.Object)
	 */
	@Override
	@Transactional
	public Pledge save(Pledge pledge) {
		return pledgeRepository.save(pledge);
	}

}
