package com.myn.general.datasource2;

import java.util.List;

import com.myn.general.oldstyle.domain.Contact;

/**
 *
 * @Author Yogesh.Manware
 *
 */

interface ContactDao {
	public List<Contact> findAll();

	public void update(Contact contact);
}
