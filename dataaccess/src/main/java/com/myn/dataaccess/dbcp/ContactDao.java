package com.myn.dataaccess.dbcp;

import java.util.List;

import com.myn.general.oldstyle.domain.Contact;

/**
 *
 * @Author Yogesh.Manware
 *
 */

interface ContactDao {

	public List<Contact> findAll();
}
