import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int id;

    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}

class User {
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private HashMap<Integer, Book> issuedBooks;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        issuedBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        System.out.println("Registered Users:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void displayIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books are currently issued.");
            return;
        }
        System.out.println("Issued Books:");
        for (Book book : issuedBooks.values()) {
            System.out.println(book);
        }
    }

    public void issueBook(int bookId, int userId) {
        Book book = searchBook(bookId);
        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }
        if (!issuedBooks.containsKey(bookId)) {
            issuedBooks.put(bookId, book);
            System.out.println("Book '" + book.getTitle() + "' issued to user with ID " + userId);
        } else {
            System.out.println("Book '" + book.getTitle() + "' is already issued.");
        }
    }

    public void returnBook(int bookId) {
        if (issuedBooks.containsKey(bookId)) {
            issuedBooks.remove(bookId);
            System.out.println("Book with ID " + bookId + " returned successfully.");
        } else {
            System.out.println("Book with ID " + bookId + " is not issued.");
        }
    }

    public Book searchBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public User searchUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void reset() {
        books.clear();
        users.clear();
        issuedBooks.clear();
        System.out.println("Library reset successfully.");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Remove Book");
            System.out.println("4. Display Available Books");
            System.out.println("5. Display Registered Users");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. View Issued Books");
            System.out.println("9. Reset Library");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.addBook(new Book(title, author, bookId));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.addUser(new User(userName, userId));
                    System.out.println("User added successfully.");
                    break;
                case 3:
                    System.out.print("Enter ID of the book to remove: ");
                    int removeId = scanner.nextInt();
                    library.removeBook(removeId);
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    library.displayUsers();
                    break;
                case 6:
                    System.out.print("Enter ID of the book to issue: ");
                    int issueBookId = scanner.nextInt();
                    System.out.print("Enter ID of the user who is issuing the book: ");
                    int issueUserId = scanner.nextInt();
                    library.issueBook(issueBookId, issueUserId);
                    break;
                case 7:
                    System.out.print("Enter ID of the book to return: ");
                    int returnBookId = scanner.nextInt();
                    library.returnBook(returnBookId);
                    break;
                case 8:
                    library.displayIssuedBooks();
                    break;
                case 9:
                    library.reset();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 10.");
            }
        } while (choice != 10);

        scanner.close();
    }
}
