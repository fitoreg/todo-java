# Çka ka me bo' - Java TODO REST API

## Hyrje
Aplikacioni Çka ka me bo' është një REST API (Representational State Transfer) i zhvilluar në Java, duke perdorur Spring Boot librarinë. 

Arsyeja e përdorimit të Spring Boot, është thjeshtësia dhe shpejtësia e zhvillimit të një API duke utilizuar ketë teknologji. Gjithashtu, përmes Maven Dependency management, e kemi më të lehtë t'i menaxhojmë libraritë.

## Libraritë
Libraritë të cilat i kam përdorur në projekt janë si vijojnë:

* Spring Boot Framework;
* H2 Database for SQL;
* JUnit Vintage.

## Struktura

Projekti është zhvilluar duke e ndarë në tri shtresa (paketa):

* Model
* Repository
* Controller

### Model

Modeli, apo klasa `TodoItem` mban informatat për një Todo. Secili objekt përbehet nga një id unike, titull dhe status `isDone`.

    public TodoItem(Long id, String title, boolean isDone) {
        this.id = id;
        this.title = title;
        this.isDone = isDone;
    }

### Repository

Repository na shërben për t'i ruajtur Todo Items në databazen lokale.

### Controller

Më anë të kontrollerit, i definojme aksionet CRUD (Create, Read, Update, Delete) apo në metodologjine e REST - GET, POST, PUT, DELETE. Në klasën `TodoController` i kemi te definuar keto metoda:

	public class TodoController {

    @Autowired
    private TodoItemRepository todoRepository;

    @GetMapping
    public List<TodoItem> findAll() {
        return todoRepository.findAll();
    }

    @PostMapping
    public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    @PutMapping TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
    }
    
## GUI
GUI (Graphical User Interface) është zhvilluar në HTML/CSS, ndersa API është thirrur përmes JavaScript. Pasi të bëhet `run` projekti, në follderin `~/resources/templates/index.html` mund ta hapni front-end të projektit dhe t'i testoni funksionet.

## Instalimi

Për ta testuar programin, fillimisht duhet të instalohet Spring framework (https://www.jetbrains.com/help/idea/spring-boot.html). Pastaj, programi mund të startohet më anë të klases `TodoApplication`:

	@SpringBootApplication
	public class TodoApplication {
		public static void main(String[] args) {
			// Run the REST API
			SpringApplication.run(TodoApplication.class, args);
		}
	}  