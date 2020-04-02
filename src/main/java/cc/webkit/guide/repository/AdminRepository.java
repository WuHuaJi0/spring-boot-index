package cc.webkit.guide.repository;

import cc.webkit.guide.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin,Long> {
    Admin findById(long id);
    Admin findByUsernameAndPassword(String username, String password);
}
