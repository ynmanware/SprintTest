package com.myn.general.datasource2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.myn.general.oldstyle.domain.Contact;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {
	private Log log = LogFactory.getLog(JdbcContactDao.class);
	private DataSource dataSource;
	private SelectAllContacts selectAllContacts;

	private UpdateContact updateContact;

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		selectAllContacts = new SelectAllContacts(dataSource);
		updateContact = new UpdateContact(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void update(Contact contact) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("first_name", contact.getFirstName());
		paramMap.put("last_name", contact.getLastName());
		paramMap.put("birth_date", contact.getBirthDate());
		paramMap.put("id", contact.getId());
		updateContact.updateByNamedParam(paramMap);
		log.info("Existing contact updated with id: " + contact.getId());
	}

	public List<Contact> findAll() {
		return selectAllContacts.execute();
	}
}
