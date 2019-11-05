package upjs.sk.Prezencka.storage;

import java.util.List;

public interface SubjectDAO {

	List<Subject> getAll();

	Subject save(Subject subject);

}
