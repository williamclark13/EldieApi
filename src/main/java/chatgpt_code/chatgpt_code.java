package chatgpt_code;

//public class chatgpt_code {
////	Code is in the same order as the commands
////		-Write code so that if port is in use kill that process on the port and run again on same port.
////		-Write code in java for rest api that implements repository, service, and storage for help request without using interfaces.
////		-Write code to create associated mealrepository, mealstorage, and mealservice classes without using interfaces.
////		-add necessary error handling, javadocs, and code for edlieapiapp class
////		-add necessary error handling, javadocs, and code for code associated with helprequest/helprequestcontroller/helprequestservice/
////				helprequestrepository/helprequeststorage
////		-add necessary error handling, javadocs, and code for code associated with meal/mealcontroller/mealservice/mealrepository/mealstorage
//}
//
////Write code so that if port is in use kill that process on the port and run again on same port.
//
////@SpringBootApplication
////class EldieApiApp {
////	public static void main(String[] args) throws IOException {
////		int port = 8008;
////		if (isPortInUse(port)) {
////			System.out.println("Port " + port + " is already in use.");
////			killProcessOnPort(port);
////		}
////		SpringApplication.run(EldieApiApp.class, args);
////	}
////
////	private static boolean isPortInUse(int port) {
////		try {
////			ServerSocket serverSocket = new ServerSocket(port);
////			serverSocket.close();
////			return false;
////		} catch (IOException e) {
////			return true;
////		}
////	}
////
////	private static void killProcessOnPort(int port) throws IOException {
////		String command = "lsof -i :" + port + " | awk 'NR!=1 {print $2}' | xargs kill";
////		ProcessBuilder processBuilder = new ProcessBuilder();
////		processBuilder.command("bash", "-c", command);
////		Process process = processBuilder.start();
////		try {
////			process.waitFor();
////		} catch (InterruptedException e) {
////			Thread.currentThread().interrupt();
////		}
////	}
////}
////
//////---------------------------------------------------------------------------------------------------------------------------------------//
////
//////Write code in java for rest api that implements repository, service, and storage for help request without using interfaces.
////
////class HelpRequest {
////	private Long id;
////	private String requesterName;
////	private LocalDateTime requestedDateTime;
////	private String helpType;
////	private LocalDateTime fulfilledDateTime;
////
////	public HelpRequest(Long id, String requesterName, LocalDateTime requestedDateTime, String helpType) {
////		this.setId(id);
////		this.requesterName = requesterName;
////		this.requestedDateTime = requestedDateTime;
////		this.helpType = helpType;
////	}
////
////	public LocalDateTime getRequestedDateTime() {
////		return requestedDateTime;
////	}
////
////	public String getHelpType() {
////		return helpType;
////	}
////
////	public LocalDateTime getFulfilledDateTime() {
////		return fulfilledDateTime;
////	}
////
////	public void setFulfilledDateTime(LocalDateTime fulfilledDateTime) {
////		this.fulfilledDateTime = fulfilledDateTime;
////	}
////
////	public String getRequesterName() {
////		return requesterName;
////	}
////
////	public Long getId() {
////		return this.id;
////	}
////
////	public void setId(Long id) {
////		this.id = id;
////	}
////}
////
////class HelpRequestRepository {
////	private List<HelpRequest> helpRequests = new ArrayList<>();
////
////	public List<HelpRequest> findAll() {
////		return helpRequests;
////	}
////
////	public HelpRequest findById(Long id) {
////		for (HelpRequest helpRequest : helpRequests) {
////			if (helpRequest.getId().equals(id)) {
////				return helpRequest;
////			}
////		}
////		return null;
////	}
////
////	public HelpRequest save(HelpRequest helpRequest) {
////		helpRequests.add(helpRequest);
////		return helpRequest;
////	}
////
////	public void deleteById(Long id) {
////		HelpRequest helpRequestToRemove = null;
////		for (HelpRequest helpRequest : helpRequests) {
////			if (helpRequest.getId().equals(id)) {
////				helpRequestToRemove = helpRequest;
////				break;
////			}
////		}
////		if (helpRequestToRemove != null) {
////			helpRequests.remove(helpRequestToRemove);
////		}
////	}
////}
////
////@Component
////class HelpRequestStorage {
////	private HelpRequestRepository helpRequestRepository;
////
////	public HelpRequestStorage(HelpRequestRepository helpRequestRepository) {
////		this.helpRequestRepository = helpRequestRepository;
////	}
////
////	public HelpRequest createHelpRequest(String requesterName, String helpType) {
////		Long id = getNextId();
////		LocalDateTime requestedDateTime = LocalDateTime.now();
////		HelpRequest helpRequest = new HelpRequest(id, requesterName, requestedDateTime, helpType);
////		helpRequestRepository.save(helpRequest);
////		return helpRequest;
////	}
////
////	public List<HelpRequest> getAllHelpRequests() {
////		return helpRequestRepository.findAll();
////	}
////
////	public HelpRequest getHelpRequestById(Long id) {
////		return helpRequestRepository.findById(id);
////	}
////
////	public void markHelpRequestFulfilled(Long id) {
////		HelpRequest helpRequest = helpRequestRepository.findById(id);
////		if (helpRequest != null) {
////			helpRequest.setFulfilledDateTime(LocalDateTime.now());
////		}
////	}
////
////	private Long getNextId() {
////		List<HelpRequest> helpRequests = helpRequestRepository.findAll();
////		Long maxId = 0L;
////		for (HelpRequest helpRequest : helpRequests) {
////			if (helpRequest.getId() > maxId) {
////				maxId = helpRequest.getId();
////			}
////		}
////		return maxId + 1;
////	}
////}
////
////@RestController
////@RequestMapping("/api/v1/help-requests")
////class HelpRequestController {
////	private HelpRequestStorage helpRequestStorage;
////
////	public HelpRequestController(HelpRequestStorage helpRequestStorage) {
////		this.helpRequestStorage = helpRequestStorage;
////	}
////
////	@PostMapping
////	public HelpRequest createHelpRequest(@RequestBody HelpRequest helpRequest) {
////		String requesterName = helpRequest.getRequesterName();
////		String helpType = helpRequest.getHelpType();
////		return helpRequestStorage.createHelpRequest(requesterName, helpType);
////	}
////
////	@GetMapping
////	public List<HelpRequest> getAllHelpRequests() {
////		return helpRequestStorage.getAllHelpRequests();
////	}
////
////	@GetMapping("/{id}")
////	public HelpRequest getHelpRequestById(@PathVariable Long id) {
////		return helpRequestStorage.getHelpRequestById(id);
////	}
////
////	@PutMapping("/{id}/fulfilled")
////	public void markHelpRequestFulfilled(@PathVariable Long id) {
////		helpRequestStorage.markHelpRequestFulfilled(id);
////	}
////}
////
////class HelpRequestService {
////	private final HelpRequestRepository helpRequestRepository;
////
////	public HelpRequestService(HelpRequestRepository helpRequestRepository) {
////		this.helpRequestRepository = helpRequestRepository;
////	}
////
////	public List<HelpRequest> getAllHelpRequests() {
////		return helpRequestRepository.findAll();
////	}
////
////	public HelpRequest getHelpRequestById(Long id) {
////		return helpRequestRepository.findById(id);
////	}
////
////	public void addHelpRequest(HelpRequest helpRequest) {
////		helpRequestRepository.save(helpRequest);
////	}
////
////	public void fulfillHelpRequest(Long id) {
////		HelpRequest helpRequest = helpRequestRepository.findById(id);
////		if (helpRequest != null) {
////			helpRequest.setFulfilledDateTime(LocalDateTime.now());
////			helpRequestRepository.save(helpRequest);
////		}
////	}
////}
////
//////---------------------------------------------------------------------------------------------------------------------------------------//
////
//////Write code to create associated mealrepository, mealstorage, and mealservice classes without using interfaces.
////
////class Meal {
////	private String name;
////	private List<String> combinations;
////
////	public Meal(String name, List<String> combinations) {
////		this.name = name;
////		this.combinations = combinations;
////	}
////
////	public String getName() {
////		return name;
////	}
////
////	public List<String> getCombinations() {
////		return combinations;
////	}
////}
////
////class MealRepository {
////	private MealStorage mealStorage;
////
////	public MealRepository(MealStorage mealStorage) {
////		this.mealStorage = mealStorage;
////	}
////
////	public List<String> getMealCombinations(String mealType) {
////		for (Meal meal : mealStorage.getAllMeals()) {
////			if (meal.getName().equalsIgnoreCase(mealType)) {
////				return meal.getCombinations();
////			}
////		}
////		return null;
////	}
////}
////
////class MealStorage {
////	private List<Meal> meals = Arrays.asList(
////			new Meal("breakfast",
////					Arrays.asList("sausage, grit, tea, toast", "sausage, toast, coffee, scrambled eggs",
////							"sunny side up eggs, toast, water")),
////			new Meal("lunch",
////					Arrays.asList("turkey sandwich, potato chips, soda", "caesar salad, iced tea",
////							"grilled chicken wrap, fries, lemonade")),
////			new Meal("dinner", Arrays.asList("spaghetti and meatballs, red wine",
////					"filet mignon, baked potato, green beans, beer", "grilled salmon, white wine")));
////
////	public List<Meal> getAllMeals() {
////		return meals;
////	}
////}
////
////@RestController
////@RequestMapping(path = "/api/v1/meal")
////class MealController {
////	private MealService mealService;
////
////	public MealController() {
////		MealStorage mealStorage = new MealStorage();
////		MealRepository mealRepository = new MealRepository(mealStorage);
////		this.mealService = new MealService(mealRepository);
////	}
////
////	@GetMapping("/breakfast")
////	public List<String> getBreakfastCombos() {
////		return mealService.getMealCombinations("breakfast");
////	}
////
////	@GetMapping("/lunch")
////	public List<String> getLunchCombos() {
////		return mealService.getMealCombinations("lunch");
////	}
////
////	@GetMapping("/dinner")
////	public List<String> getDinnerCombos() {
////		return mealService.getMealCombinations("dinner");
////	}
////}
////
////class MealService {
////	private MealRepository mealRepository;
////
////	public MealService(MealRepository mealRepository) {
////		this.mealRepository = mealRepository;
////	}
////
////	public List<String> getMealCombinations(String mealType) {
////		return mealRepository.getMealCombinations(mealType);
////	}
////}
////
////---------------------------------------------------------------------------------------------------------------------------------------//
////
////add necessary error handling, javadocs, and code for edlieapiapp class
////add necessary error handling, javadocs, and code for code associated with helprequest/helprequestcontroller/helprequestservice/
////helprequestrepository/helprequeststorage
////add necessary error handling, javadocs, and code for code associated with meal/mealcontroller/mealservice/mealrepository/mealstorage
////
////@SpringBootApplication
////class EldieApiApp {
////
////	/**
////	 * Main entry point of the EldieApiApp.
////	 *
////	 * @param args command-line arguments.
////	 * @throws IOException if there is an error while killing the process.
////	 */
////	public static void main(String[] args) throws IOException {
////		int port = 8008;
////		if (isPortInUse(port)) {
////			System.out.println("Port " + port + " is already in use.");
////			killProcessOnPort(port);
////			SpringApplication.run(EldieApiApp.class, args);
////		}
////		SpringApplication.run(EldieApiApp.class, args);
////	}
////
////	/**
////	 * Checks whether the given port is already in use or not.
////	 *
////	 * @param port the port number to check.
////	 * @return true if the port is already in use, false otherwise.
////	 */
////	private static boolean isPortInUse(int port) {
////		try (ServerSocket serverSocket = new ServerSocket(port)) {
////			serverSocket.setReuseAddress(true);
////			return false;
////		} catch (IOException e) {
////			return true;
////		}
////	}
////
////	/**
////	 * Kills the process that is using the given port number.
////	 *
////	 * @param port the port number of the process to be killed.
////	 * @throws IOException if there is an error while killing the process.
////	 */
////	private static void killProcessOnPort(int port) throws IOException {
////		String command = "lsof -i :" + port + " | awk 'NR!=1 {print $2}' | xargs kill";
////		ProcessBuilder processBuilder = new ProcessBuilder();
////		processBuilder.command("bash", "-c", command);
////		Process process = processBuilder.start();
////		try {
////			process.waitFor();
////		} catch (InterruptedException e) {
////			Thread.currentThread().interrupt();
////			throw new RuntimeException("Interrupted while waiting for process to finish", e);
////		}
////	}
////}
////
//////---------------------------------------------------------------------------------------------------------------------------------------//
////
//////add necessary error handling, javadocs, and code for code associated with helprequest/helprequestcontroller/helprequestservice/
////		helprequestrepository/helprequeststorage
////
/////**
//// * A HelpRequest represents a request for help made by a user.
//// */
////class HelpRequest {
////	private Long id;
////	private String requesterName;
////	private LocalDateTime requestedDateTime;
////	private String helpType;
////	private LocalDateTime fulfilledDateTime;
////
////	/**
////	 * Constructs a new HelpRequest object.
////	 *
////	 * @param id                the ID of the request
////	 * @param requesterName     the name of the user making the request
////	 * @param requestedDateTime the date and time when the request was made
////	 * @param helpType          the type of help requested
////	 */
////	public HelpRequest(Long id, String requesterName, LocalDateTime requestedDateTime, String helpType) {
////		this.setId(id);
////		this.requesterName = requesterName;
////		this.requestedDateTime = requestedDateTime;
////		this.helpType = helpType;
////	}
////
////	/**
////	 * Get RequestedDateTime
////	 * 
////	 * @return RequestedDateTime
////	 */
////	public LocalDateTime getRequestedDateTime() {
////		return requestedDateTime;
////	}
////
////	/**
////	 * Get HelpType
////	 * 
////	 * @return HelpType
////	 */
////	public String getHelpType() {
////		return helpType;
////	}
////
////	/**
////	 * Get FulfilledDateTime
////	 * 
////	 * @return FulfilledDateTime
////	 */
////	public LocalDateTime getFulfilledDateTime() {
////		return fulfilledDateTime;
////	}
////
////	/**
////	 * Sets the date and time when the request was fulfilled.
////	 *
////	 * @param fulfilledDateTime the date and time when the request was fulfilled
////	 */
////	public void setFulfilledDateTime(LocalDateTime fulfilledDateTime) {
////		this.fulfilledDateTime = fulfilledDateTime;
////	}
////
////	/**
////	 * Get Requester Name
////	 * 
////	 * @return requester name
////	 */
////	public String getRequesterName() {
////		return requesterName;
////	}
////
////	/**
////	 * Gets ID
////	 * 
////	 * @return id
////	 */
////	public Long getId() {
////		return this.id;
////	}
////
////	/**
////	 * Sets ID
////	 * 
////	 * @param id
////	 */
////	public void setId(Long id) {
////		this.id = id;
////	}
////}
////
/////**
//// * A HelpRequestRepository manages the storage and retrieval of HelpRequest
//// * objects.
//// */
////class HelpRequestRepository {
////	private List<HelpRequest> helpRequests = new ArrayList<>();
////
////	/**
////	 * Returns a list of all HelpRequest objects.
////	 *
////	 * @return a list of all HelpRequest objects
////	 */
////	public List<HelpRequest> findAll() {
////		return Collections.unmodifiableList(helpRequests);
////	}
////
////	/**
////	 * Finds a HelpRequest object by its ID.
////	 *
////	 * @param id the ID of the HelpRequest object to find
////	 * @return the HelpRequest object with the specified ID, or null if no such
////	 *         object exists
////	 */
////	public HelpRequest findById(Long id) {
////		for (HelpRequest helpRequest : helpRequests) {
////			if (helpRequest.getId().equals(id)) {
////				return helpRequest;
////			}
////		}
////		return null;
////	}
////
////	/**
////	 * Saves a HelpRequest object.
////	 *
////	 * @param helpRequest the HelpRequest object to save
////	 * @return the saved HelpRequest object
////	 */
////	public HelpRequest save(HelpRequest helpRequest) {
////		helpRequests.add(helpRequest);
////		return helpRequest;
////	}
////
////	/**
////	 * Deletes a HelpRequest object by its ID.
////	 *
////	 * @param id the ID of the HelpRequest object to delete
////	 * @return true if the object was deleted, false if no such object exists
////	 */
////	public boolean deleteById(Long id) {
////		HelpRequest helpRequestToRemove = null;
////		for (HelpRequest helpRequest : helpRequests) {
////			if (helpRequest.getId().equals(id)) {
////				helpRequestToRemove = helpRequest;
////				break;
////			}
////		}
////		if (helpRequestToRemove != null) {
////			helpRequests.remove(helpRequestToRemove);
////			return true;
////		}
////		return false;
////	}
////}
////
////@Component
////class HelpRequestStorage {
////	private HelpRequestRepository helpRequestRepository;
////
////	/**
////	 * Constructs a HelpRequestStorage with a HelpRequestRepository.
////	 * 
////	 * @param helpRequestRepository the HelpRequestRepository to use
////	 */
////	public HelpRequestStorage(HelpRequestRepository helpRequestRepository) {
////		this.helpRequestRepository = helpRequestRepository;
////	}
////
////	/**
////	 * Creates a new HelpRequest with the given requester name and help type.
////	 * 
////	 * @param requesterName the name of the requester
////	 * @param helpType      the type of help requested
////	 * @return the new HelpRequest object
////	 * @throws IllegalArgumentException if either argument is null or empty
////	 */
////	public HelpRequest createHelpRequest(String requesterName, String helpType) {
////		if (requesterName == null || requesterName.isEmpty()) {
////			throw new IllegalArgumentException("Requester name cannot be null or empty");
////		}
////		if (helpType == null || helpType.isEmpty()) {
////			throw new IllegalArgumentException("Help type cannot be null or empty");
////		}
////
////		Long id = getNextId();
////		LocalDateTime requestedDateTime = LocalDateTime.now();
////		HelpRequest helpRequest = new HelpRequest(id, requesterName, requestedDateTime, helpType);
////		helpRequestRepository.save(helpRequest);
////		return helpRequest;
////	}
////
////	/**
////	 * Retrieves all HelpRequest objects.
////	 * 
////	 * @return a List of all HelpRequest objects
////	 */
////	public List<HelpRequest> getAllHelpRequests() {
////		return helpRequestRepository.findAll();
////	}
////
////	/**
////	 * Retrieves a HelpRequest object by ID.
////	 * 
////	 * @param id the ID of the HelpRequest to retrieve
////	 * @return the HelpRequest object with the given ID, or null if not found
////	 * @throws IllegalArgumentException if the ID is null or less than or equal to 0
////	 */
////	public HelpRequest getHelpRequestById(Long id) {
////		if (id == null || id <= 0) {
////			throw new IllegalArgumentException("ID cannot be null or less than or equal to 0");
////		}
////
////		return helpRequestRepository.findById(id);
////	}
////
////	/**
////	 * Marks a HelpRequest as fulfilled by setting the fulfilledDateTime to the
////	 * current time.
////	 * 
////	 * @param id the ID of the HelpRequest to mark as fulfilled
////	 * @throws IllegalArgumentException if the ID is null or less than or equal to
////	 *                                  0, or if the HelpRequest with the given ID
////	 *                                  does not exist
////	 */
////	public void markHelpRequestFulfilled(Long id) {
////		if (id == null || id <= 0) {
////			throw new IllegalArgumentException("ID cannot be null or less than or equal to 0");
////		}
////
////		HelpRequest helpRequest = helpRequestRepository.findById(id);
////		if (helpRequest == null) {
////			throw new IllegalArgumentException("No HelpRequest found with ID " + id);
////		}
////
////		helpRequest.setFulfilledDateTime(LocalDateTime.now());
////	}
////
////	private Long getNextId() {
////		List<HelpRequest> helpRequests = helpRequestRepository.findAll();
////		Long maxId = 0L;
////		for (HelpRequest helpRequest : helpRequests) {
////			if (helpRequest.getId() > maxId) {
////				maxId = helpRequest.getId();
////			}
////		}
////		return maxId + 1;
////	}
////
////}
////
////@RestController
////@RequestMapping("/api/v1/help-requests")
////class HelpRequestController {
////	private HelpRequestStorage helpRequestStorage;
////
////	/**
////	 * Constructs a HelpRequestController with a HelpRequestStorage.
////	 * 
////	 * @param helpRequestStorage the HelpRequestStorage to use
////	 */
////
////	public HelpRequestController(HelpRequestStorage helpRequestStorage) {
////		this.helpRequestStorage = helpRequestStorage;
////	}
////
////	/**
////	 * 
////	 * Creates a new HelpRequest with the provided information.
////	 * 
////	 * @param helpRequest the HelpRequest to create
////	 * @return the created HelpRequest
////	 * @throws IllegalArgumentException if the provided HelpRequest is null or has
////	 *                                  an ID already assigned
////	 */
////	@PostMapping
////	public HelpRequest createHelpRequest(@RequestBody HelpRequest helpRequest) {
////		if (helpRequest == null || helpRequest.getId() != null) {
////			throw new IllegalArgumentException("Invalid HelpRequest");
////		}
////		String requesterName = helpRequest.getRequesterName();
////		String helpType = helpRequest.getHelpType();
////		return helpRequestStorage.createHelpRequest(requesterName, helpType);
////	}
////
////	/**
////	 * 
////	 * Retrieves all HelpRequests.
////	 * 
////	 * @return a List of all HelpRequests
////	 */
////	@GetMapping
////	public List<HelpRequest> getAllHelpRequests() {
////		return helpRequestStorage.getAllHelpRequests();
////	}
////
////	/**
////	 * 
////	 * Retrieves a HelpRequest by ID.
////	 * 
////	 * @param id the ID of the HelpRequest to retrieve
////	 * @return the retrieved HelpRequest, or null if not found
////	 */
////	@GetMapping("/{id}")
////	public HelpRequest getHelpRequestById(@PathVariable Long id) {
////		return helpRequestStorage.getHelpRequestById(id);
////	}
////
////	/**
////	 * 
////	 * Marks a HelpRequest as fulfilled.
////	 * 
////	 * @param id the ID of the HelpRequest to mark as fulfilled
////	 * @throws IllegalArgumentException if the provided ID is null or invalid
////	 */
////	@PutMapping("/{id}/fulfilled")
////	public void markHelpRequestFulfilled(@PathVariable Long id) {
////		if (id == null || id <= 0) {
////			throw new IllegalArgumentException("Invalid HelpRequest ID");
////		}
////		helpRequestStorage.markHelpRequestFulfilled(id);
////	}
////}
////
/////**
//// * Service class for managing HelpRequests.
//// */
////@Service
////class HelpRequestService {
////	private final HelpRequestRepository helpRequestRepository;
////
////	/**
////	 * Constructs a HelpRequestService with a HelpRequestRepository.
////	 * 
////	 * @param helpRequestRepository the HelpRequestRepository to use
////	 */
////	public HelpRequestService(HelpRequestRepository helpRequestRepository) {
////		this.helpRequestRepository = helpRequestRepository;
////	}
////
////	/**
////	 * Returns a list of all HelpRequests.
////	 * 
////	 * @return a list of HelpRequests
////	 */
////	public List<HelpRequest> getAllHelpRequests() {
////		return helpRequestRepository.findAll();
////	}
////
////	/**
////	 * Returns a HelpRequest with the specified id.
////	 * 
////	 * @param id the id of the HelpRequest to retrieve
////	 * @return the HelpRequest with the specified id, or null if no such HelpRequest
////	 *         exists
////	 */
////	public HelpRequest getHelpRequestById(Long id) {
////		if (id == null) {
////			throw new IllegalArgumentException("id cannot be null");
////		}
////		return helpRequestRepository.findById(id);
////	}
////
////	/**
////	 * Adds a new HelpRequest to the repository.
////	 * 
////	 * @param helpRequest the HelpRequest to add
////	 */
////	public void addHelpRequest(HelpRequest helpRequest) {
////		if (helpRequest == null) {
////			throw new IllegalArgumentException("helpRequest cannot be null");
////		}
////		helpRequestRepository.save(helpRequest);
////	}
////
////	/**
////	 * Marks the HelpRequest with the specified id as fulfilled.
////	 * 
////	 * @param id the id of the HelpRequest to mark as fulfilled
////	 */
////	public void fulfillHelpRequest(Long id) {
////		if (id == null) {
////			throw new IllegalArgumentException("id cannot be null");
////		}
////		HelpRequest helpRequest = helpRequestRepository.findById(id);
////		if (helpRequest != null) {
////			helpRequest.setFulfilledDateTime(LocalDateTime.now());
////			helpRequestRepository.save(helpRequest);
////		} else {
////			throw new IllegalArgumentException("No HelpRequest with id " + id + " exists");
////		}
////	}
////}
////
//////---------------------------------------------------------------------------------------------------------------------------------------//
////
////add necessary error handling, javadocs, and code for code associated with meal/mealcontroller/mealservice/mealrepository/mealstorage
////
////public class Meal {
////	private String name;
////	private List<String> combinations;
////
////	/**
////	 * Constructs a Meal with a name and list of combinations.
////	 *
////	 * @param name         the name of the meal
////	 * @param combinations the list of combinations for the meal
////	 */
////	public Meal(String name, List<String> combinations) {
////		this.name = name;
////		this.combinations = combinations;
////	}
////
////	/**
////	 * Gets the name of the meal.
////	 *
////	 * @return the name of the meal
////	 */
////	public String getName() {
////		return name;
////	}
////
////	/**
////	 * Gets the list of combinations for the meal.
////	 *
////	 * @return the list of combinations for the meal
////	 */
////	public List<String> getCombinations() {
////		return combinations;
////	}
////}
////
////public class MealRepository {
////	private MealStorage mealStorage;
////
////	public MealRepository(MealStorage mealStorage) {
////		this.mealStorage = mealStorage;
////	}
////
////	/**
////	 * Gets the list of combinations for the meal with the specified name.
////	 *
////	 * @param mealType the name of the meal to get combinations for
////	 * @return the list of combinations for the meal, or null if no meal with that
////	 *         name was found
////	 */
////	public List<String> getMealCombinations(String mealType) {
////		for (Meal meal : mealStorage.getAllMeals()) {
////			if (meal.getName().equalsIgnoreCase(mealType)) {
////				return meal.getCombinations();
////			}
////		}
////		// If no meal with that name was found, return null
////		return null;
////	}
////}
////
////@Component
////public class MealStorage {
////	private List<Meal> meals = Arrays.asList(
////			new Meal("breakfast",
////					Arrays.asList("sausage, grit, tea, toast", "sausage, toast, coffee, scrambled eggs",
////							"sunny side up eggs, toast, water")),
////			new Meal("lunch",
////					Arrays.asList("turkey sandwich, potato chips, soda", "caesar salad, iced tea",
////							"grilled chicken wrap, fries, lemonade")),
////			new Meal("dinner", Arrays.asList("spaghetti and meatballs, red wine",
////					"filet mignon, baked potato, green beans, beer", "grilled salmon, white wine")));
////
////	/**
////	 * Gets a list of all the meals.
////	 *
////	 * @return a list of all the meals
////	 */
////	public List<Meal> getAllMeals() {
////		return meals;
////	}
////}
////
////@RestController
////@RequestMapping(path = "/api/v1/meal")
////public class MealController {
////	private MealService mealService;
////
////	public MealController() {
////		MealStorage mealStorage = new MealStorage();
////		MealRepository mealRepository = new MealRepository(mealStorage);
////		this.mealService = new MealService(mealRepository);
////	}
////
////	@GetMapping("/breakfast")
////	public ResponseEntity<List<String>> getBreakfastCombos() {
////		List<String> combos = mealService.getMealCombinations("breakfast");
////		if (combos == null) {
////			return ResponseEntity.notFound().build();
////		} else {
////			return ResponseEntity.ok(combos);
////		}
////	}
////
////	@GetMapping("/lunch")
////	public ResponseEntity<List<String>> getLunchCombos() {
////		List<String> combos = mealService.getMealCombinations("lunch");
////		if (combos == null) {
////			return ResponseEntity.notFound().build();
////		} else {
////			return ResponseEntity.ok(combos);
////		}
////	}
////
////	@GetMapping("/dinner")
////	public ResponseEntity<List<String>> getDinnerCombos() {
////		List<String> combos = mealService.getMealCombinations("dinner");
////		if (combos == null) {
////			return ResponseEntity.notFound().build();
////		} else {
////			return ResponseEntity.ok(combos);
////		}
////	}
////}
////
////@Service
////public class MealService {
////	private MealRepository mealRepository;
////
////	public MealService(MealRepository mealRepository) {
////		this.mealRepository = mealRepository;
////	}
////
////	/**
////	 * Gets the list of combinations for the meal with the specified name.
////	 *
////	 * @param mealType the name of the meal to get combinations for
////	 * @return the list of combinations for the meal, or null if no meal with that
////	 *         name was found
////	 */
////	public List<String> getMealCombinations(String mealType) {
////		return mealRepository.getMealCombinations(mealType);
////	}
////}
