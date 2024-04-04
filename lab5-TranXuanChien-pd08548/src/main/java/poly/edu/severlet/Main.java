package poly.edu.severlet;
import java.util.List;

import poly.edu.dao.UserDao;
import poly.edu.model.User;

public class Main {
	public static void main(String[] args) {
        // Tạo một đối tượng UserDao
        UserDao userDao = new UserDao();

        // Từ khóa bạn muốn tìm kiếm
        String keyWord = "123"; // Đổi từ khóa này thành từ khóa bạn muốn

        // Gọi phương thức findByKeyWork với từ khóa và nhận danh sách người dùng thỏa mãn
        List<User> users = userDao.findByKeyWord(keyWord);

        // In danh sách người dùng thỏa mãn
        for (User user : users) {
            System.out.println("ID: " + user.getId() + ", Full Name: " + user.getFullname() + ", Email: " + user.getEmail() + ", Admin: " + user.getId());
        }
    }
}
