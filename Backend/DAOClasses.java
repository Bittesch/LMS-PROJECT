public class StudentDAO {
  public List<Student> getAllStudents() throws SQLException {
    Connection conn = DatabaseConnection.getConnection();
    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM students");
    ResultSet rs = pstmt.executeQuery();
    List<Student> students = new ArrayList<>();

    while (rs.next()) {
      Student student = new Student();
      student.setId(rs.getInt("id"));
      student.setName(rs.getString("name"));
      student.setEmail(rs.getString("email"));
      student.setPassword(rs.getString("password"));
      students.add(student);
    }

    rs.close();
    pstmt.close();
    conn.close();

    return students;
  }

  public void createStudent(Student student) throws SQLException {
    Connection conn = DatabaseConnection.getConnection();
    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO students (name, email, password) VALUES (?, ?, ?)");
    pstmt.setString(1, student.getName());
    pstmt.setString(2, student.getEmail());
    pstmt.setString(3, student.getPassword());
    pstmt.executeUpdate();

    pstmt.close();
    conn.close();
  }
}

public class CourseDAO {
  public List<Course> getCourses(int page, String sort) throws SQLException {
    Connection conn = DatabaseConnection.getConnection();
    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM courses ORDER BY " + sort + " LIMIT ?, ?");
    pstmt.setInt(1, (page - 1) * 10);
    pstmt.setInt(2, 10);
    ResultSet rs = pstmt.executeQuery();
    List<Course> courses = new ArrayList<>();

    while (rs.next()) {
      Course course = new Course();
      course.setId(rs.getInt("id"));
      course.setName(rs.getString("name"));
      course.setDescription(rs.getString("description"));
      courses.add(course);
    }

    rs.close();
    pstmt.close();
    conn.close();

    return courses;
  }

  public void createCourse(Course course) throws SQLException {
    Connection conn = DatabaseConnection.getConnection();
    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO courses (name, description) VALUES (?, ?)");
    pstmt.setString(1, course.getName());
    pstmt.setString(2, course.getDescription());
    pstmt.executeUpdate();

    pstmt.close();
    conn.close();
  }
}

public class EnrollmentDAO {
  public List<Enrollment> getAllEnrollments() throws SQLException {
    Connection conn = DatabaseConnection.getConnection();
    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM enrollments");
    ResultSet rs = pstmt.executeQuery();
    List<Enrollment> enrollments = new ArrayList<>();

    while (rs.next()) {
      Enrollment enrollment = new Enrollment();
      enrollment.setId(rs.getInt("id"));
      enrollment.setStudentId(rs.getInt("student_id"));
      enrollment.setCourseId(rs.getInt("course_id"));
      enrollments.add(enrollment);
    }

    rs.close();
    pstmt.close();
    conn.close();

    return enrollments;
  }

  public void createEnrollment(Enrollment enrollment) throws SQLException {
    Connection conn = DatabaseConnection.getConnection();
    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)");
    pstmt.setInt(1, enrollment.getStudentId());
    pstmt.setInt(2, enrollment.getCourseId());
    pstmt.executeUpdate();

    pstmt.close();
    conn.close();
  }
}