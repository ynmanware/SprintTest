package com.myn.dataaccess.dbcp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myn.general.oldstyle.domain.Contact;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {

  @Resource(name = "jdbcTemplate")
  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void afterPropertiesSet() throws Exception {
    if (jdbcTemplate == null) {
      throw new BeanCreationException("Must set jdbcTemplate on ContactDao");
    }
  }

  public List<Contact> findAll() {
    String sql = "select id, first_name, last_name, birth_date from contact";
    return jdbcTemplate.query(sql, new ContactMapper());
  }

  private static final class ContactMapper implements RowMapper<Contact> {
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
      Contact contact = new Contact();
      contact.setId(rs.getLong("id"));
      contact.setFirstName(rs.getString("first_name"));
      contact.setLastName(rs.getString("last_name"));
      contact.setBirthDate(rs.getDate("birth_date"));
      return contact;
    }
  }
}
