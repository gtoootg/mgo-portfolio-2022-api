package com.mgoportfolio2022api.mgoportfolio2022api.dao;

import com.mgoportfolio2022api.mgoportfolio2022api.model.user.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

  Optional<Role> findByName(String name);

}
