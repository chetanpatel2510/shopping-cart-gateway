/**
 * 
 */
package com.shoppingcart.gateway.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.gateway.entities.User;

/**
 * @author root
 *
 */
@Repository
public interface UserRepository extends CassandraRepository<User, String>{

	User findByUsername(String username);
}
