package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao {
	
	// operations to be implemented
	public String save(String sname, Integer sage, String saddress);

	public Student findById(Integer sid);

	public String updateById(Student student);

	public String deleteById(Integer sid);

}
