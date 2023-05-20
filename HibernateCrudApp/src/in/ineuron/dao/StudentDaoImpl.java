package in.ineuron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.dto.Student;
import in.ineuron.util.HibernateUtil;

//Persistence logic using JDBC API
public class StudentDaoImpl implements IStudentDao {

	Session session = HibernateUtil.getSession();

	@Override
	public String updateById(Student student) {
		Transaction transaction = session.beginTransaction();
		boolean flag = false;
		String status = "";

		try {
			if (transaction != null) {
				session.merge(student);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				status = "success";
			} else {
				transaction.rollback();
				status = "failure";
			}
		}

		return status;
	}

	@Override
	public String save(String sname, Integer sage, String saddress) {
		Transaction transaction = session.beginTransaction();
		boolean flag = false;
		String status = "";

		try {
			if (transaction != null) {
				Student student = new Student();
				student.setSname(sname);
				student.setSage(sage);
				student.setSaddress(saddress);

				session.save(student);
				flag = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				status = "success";
			} else {
				transaction.rollback();
				status = "failure";
			}
		}
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		Student student = session.get(Student.class, sid);
		if (student != null)
			return student;
		else
			return null;
	}

	@Override
	public String deleteById(Integer sid) {
		Student student = findById(sid);

		Transaction transaction = session.beginTransaction();
		boolean flag = false;
		String status = "";

		try {
			if (student != null) {
				session.delete(student);
				flag = true;
			} else {
				return "not found";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				status = "success";
			} else {
				transaction.rollback();
				status = "failure";
			}
		}
		return status;
	}

}
