package kz.bitlab.java_sb.db;

import java.util.ArrayList;

// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

public class DBManager {
    private static ArrayList<Film> films = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Task> tasks = new ArrayList<>();

    private static Long id_films = 4L;
    private static Long id_items = 7L;
    private static Long id_students = 6L;
    private static Long id_tasks = 6L;

    static {
        films.add(new Film(1L, "Matrix", "About Neo", 2002, 8.8));
        films.add(new Film(2L, "Harry Potter", "About Harry Potter", 2001, 8.5));
        films.add(new Film(3L, "Duna", "About Maudib", 2023, 8.7));
    }

    static {
        items.add(new Item(1L, "Mac Book Pro", "8 GB RAM 255 GB SSD Intel Core i7", 1199.99, 10));
        items.add(new Item(2L, "Mac Book Pro", "16 GB RAM 500 GB SSD Apple M1", 1499.99, 10));
        items.add(new Item(3L, "Mac Book Pro", "16 GB RAM 1 TB SSD Apple M1", 1799.99, 10));
        items.add(new Item(4L, "ASUS Tuf Gaming", "16 GB RAM 500 GB SSD Intel Core i7", 1299.99, 15));
        items.add(new Item(5L, "HP Laser Pro", "8 GB RAM 500 GB SSD Intel Core i5", 999.99, 7));
        items.add(new Item(6L, "Lenovo Legion", "32 GB RAM 512 GB SSD Intel Core i7", 1399.99, 7));
    }

    static {
        students.add(new Student(1L, "Ilyas", "Zhuanyshev", 88));
        students.add(new Student(2L, "Madina", "Adltetova", 77));
        students.add(new Student(3L, "Serik", "Erikov", 48));
        students.add(new Student(4L, "Patrick", "Zuckerberg", 99));
        students.add(new Student(5L, "Sabina", "Assetova", 33));
    }

    static {
        tasks.add(new Task(1L, "Create API on JAVA EE", "API creation and better understanding SQL", "2021-10-23", true));
        tasks.add(new Task(2L, "Clean house and buy products", "", "2021-10-25", true));
        tasks.add(new Task(3L, "Finish all homeworks", "", "2021-10-28", false));
        tasks.add(new Task(4L, "Make an appointment", "", "2021-12-12", false));
        tasks.add(new Task(5L, "Learn Italian", "", "2021-01-05", false));
    }

    public static ArrayList<Film> getAlFilms() {
        return films;
    }

    public static void addFilm(Film film) {
        film.setId(id_films);
        id_films++;
        films.add(film);
    }

    public static ArrayList<Item> getAllItems() {
        return items;
    }

    public static void addItem(Item item) {
        item.setId(id_films);
        id_items++;
        items.add(item);
    }

    public static Item getItemById(Long id) {
        return items.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    public static int getItemIndex(Long id) {
        for (int i = 0; i < getAllItems().size(); i++) {
            if (getAllItems().get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static void updateItemById(Long id, Item item) {
        items.set(getItemIndex(id), item);
    }

    public static void deleteItemById(Long id) {
        items.remove(getItemById(id));
    }

    public static ArrayList<Student> getAllStudents() {
        return students;
    }

    public static void addStudent(Student student) {
        student.setId(id_students);
        student.setMark();
        id_students++;
        students.add(student);
    }

    public static ArrayList<Task> getAllTasks() {
        return tasks;
    }

    public static void addTask(Task task) {
        task.setId(id_tasks);
        id_tasks++;
        tasks.add(task);
    }

    public static Task getTaskById(Long id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public static int getTaskIndex(Long id) {
        for (int i = 0; i < getAllTasks().size(); i++) {
            if (getAllTasks().get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static void updateTaskById(Long id, Task task) {
        tasks.set(getTaskIndex(id), task);
    }

    public static void deleteTaskById(Long id) {
        tasks.remove(getTaskById(id));
    }
}
