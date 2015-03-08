package com.myn.general.datasource1;

import java.util.List;

import com.myn.general.oldstyle.domain.Contact;

/**
 *
 * @Author Yogesh.Manware
 *
 */

interface ContactDao {
	
	public List<Contact> findAllWithDetail();

	public List<Contact> findAll();

	public String findFirstNameById(Long id);

	public String findFirstNameById2(Long id);

}
