@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  req.getRequestDispatcher("register.jsp").forward(req, resp);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  // Handle form submission
  String username = req.getParameter("username");
  String password = req.getParameter("password");
  String email = req.getParameter("email");

  User user = new User();
  user.setUsername(username);
  user.setPassword(password);
  user.setEmail(email);

  userDAO.createUser(user);

  resp.sendRedirect("login.jsp");
}