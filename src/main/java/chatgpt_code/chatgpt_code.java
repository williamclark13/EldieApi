package chatgpt_code;

import java.io.IOException;
import java.net.ServerSocket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class chatgpt_code {
//	Code is in the same order as the commands
//		-Write code so that if port is in use kill that process on the port and run again on same port.
//		-Write code in java for rest api that implements repository, service, and storage for help request without using interfaces.
//		-Write code to create associated mealrepository, mealstorage, and mealservice classes without using interfaces.
}

@SpringBootApplication
class EldieApiApp {
	public static void main(String[] args) throws IOException {
		int port = 8008;
		if (isPortInUse(port)) {
			System.out.println("Port " + port + " is already in use.");
			killProcessOnPort(port);
		}
		SpringApplication.run(EldieApiApp.class, args);
	}

	private static boolean isPortInUse(int port) {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			serverSocket.close();
			return false;
		} catch (IOException e) {
			return true;
		}
	}

	private static void killProcessOnPort(int port) throws IOException {
		String command = "lsof -i :" + port + " | awk 'NR!=1 {print $2}' | xargs kill";
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("bash", "-c", command);
		Process process = processBuilder.start();
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

//---------------------------------------------------------------------------------------------------------------------------------------//

class HelpRequest {
	private Long id;
	private String requesterName;
	private LocalDateTime requestedDateTime;
	private String helpType;
	private LocalDateTime fulfilledDateTime;

	public HelpRequest(Long id, String requesterName, LocalDateTime requestedDateTime, String helpType) {
		this.setId(id);
		this.requesterName = requesterName;
		this.requestedDateTime = requestedDateTime;
		this.helpType = helpType;
	}

	public LocalDateTime getRequestedDateTime() {
		return requestedDateTime;
	}

	public String getHelpType() {
		return helpType;
	}

	public LocalDateTime getFulfilledDateTime() {
		return fulfilledDateTime;
	}

	public void setFulfilledDateTime(LocalDateTime fulfilledDateTime) {
		this.fulfilledDateTime = fulfilledDateTime;
	}

	public String getRequesterName() {
		return requesterName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

class HelpRequestRepository {
	private List<HelpRequest> helpRequests = new ArrayList<>();

	public List<HelpRequest> findAll() {
		return helpRequests;
	}

	public HelpRequest findById(Long id) {
		for (HelpRequest helpRequest : helpRequests) {
			if (helpRequest.getId().equals(id)) {
				return helpRequest;
			}
		}
		return null;
	}

	public HelpRequest save(HelpRequest helpRequest) {
		helpRequests.add(helpRequest);
		return helpRequest;
	}

	public void deleteById(Long id) {
		HelpRequest helpRequestToRemove = null;
		for (HelpRequest helpRequest : helpRequests) {
			if (helpRequest.getId().equals(id)) {
				helpRequestToRemove = helpRequest;
				break;
			}
		}
		if (helpRequestToRemove != null) {
			helpRequests.remove(helpRequestToRemove);
		}
	}
}

@Component
class HelpRequestStorage {
	private HelpRequestRepository helpRequestRepository;

	public HelpRequestStorage(HelpRequestRepository helpRequestRepository) {
		this.helpRequestRepository = helpRequestRepository;
	}

	public HelpRequest createHelpRequest(String requesterName, String helpType) {
		Long id = getNextId();
		LocalDateTime requestedDateTime = LocalDateTime.now();
		HelpRequest helpRequest = new HelpRequest(id, requesterName, requestedDateTime, helpType);
		helpRequestRepository.save(helpRequest);
		return helpRequest;
	}

	public List<HelpRequest> getAllHelpRequests() {
		return helpRequestRepository.findAll();
	}

	public HelpRequest getHelpRequestById(Long id) {
		return helpRequestRepository.findById(id);
	}

	public void markHelpRequestFulfilled(Long id) {
		HelpRequest helpRequest = helpRequestRepository.findById(id);
		if (helpRequest != null) {
			helpRequest.setFulfilledDateTime(LocalDateTime.now());
		}
	}

	private Long getNextId() {
		List<HelpRequest> helpRequests = helpRequestRepository.findAll();
		Long maxId = 0L;
		for (HelpRequest helpRequest : helpRequests) {
			if (helpRequest.getId() > maxId) {
				maxId = helpRequest.getId();
			}
		}
		return maxId + 1;
	}
}

@RestController
@RequestMapping("/api/v1/help-requests")
class HelpRequestController {
	private HelpRequestStorage helpRequestStorage;

	public HelpRequestController(HelpRequestStorage helpRequestStorage) {
		this.helpRequestStorage = helpRequestStorage;
	}

	@PostMapping
	public HelpRequest createHelpRequest(@RequestBody HelpRequest helpRequest) {
		String requesterName = helpRequest.getRequesterName();
		String helpType = helpRequest.getHelpType();
		return helpRequestStorage.createHelpRequest(requesterName, helpType);
	}

	@GetMapping
	public List<HelpRequest> getAllHelpRequests() {
		return helpRequestStorage.getAllHelpRequests();
	}

	@GetMapping("/{id}")
	public HelpRequest getHelpRequestById(@PathVariable Long id) {
		return helpRequestStorage.getHelpRequestById(id);
	}

	@PutMapping("/{id}/fulfilled")
	public void markHelpRequestFulfilled(@PathVariable Long id) {
		helpRequestStorage.markHelpRequestFulfilled(id);
	}
}

class HelpRequestService {
	private final HelpRequestRepository helpRequestRepository;

	public HelpRequestService(HelpRequestRepository helpRequestRepository) {
		this.helpRequestRepository = helpRequestRepository;
	}

	public List<HelpRequest> getAllHelpRequests() {
		return helpRequestRepository.findAll();
	}

	public HelpRequest getHelpRequestById(Long id) {
		return helpRequestRepository.findById(id);
	}

	public void addHelpRequest(HelpRequest helpRequest) {
		helpRequestRepository.save(helpRequest);
	}

	public void fulfillHelpRequest(Long id) {
		HelpRequest helpRequest = helpRequestRepository.findById(id);
		if (helpRequest != null) {
			helpRequest.setFulfilledDateTime(LocalDateTime.now());
			helpRequestRepository.save(helpRequest);
		}
	}
}

//---------------------------------------------------------------------------------------------------------------------------------------//

class Meal {
	private String name;
	private List<String> combinations;

	public Meal(String name, List<String> combinations) {
		this.name = name;
		this.combinations = combinations;
	}

	public String getName() {
		return name;
	}

	public List<String> getCombinations() {
		return combinations;
	}
}

class MealRepository {
    private MealStorage mealStorage;

    public MealRepository(MealStorage mealStorage) {
        this.mealStorage = mealStorage;
    }
    public List<String> getMealCombinations(String mealType) {
        for (Meal meal : mealStorage.getAllMeals()) {
            if (meal.getName().equalsIgnoreCase(mealType)) {
                return meal.getCombinations();
            }
        }
        return null;
    }
}

class MealStorage {
    private List<Meal> meals = Arrays.asList(
            new Meal("breakfast", Arrays.asList("sausage, grit, tea, toast", "sausage, toast, coffee, scrambled eggs", "sunny side up eggs, toast, water")),
            new Meal("lunch", Arrays.asList("turkey sandwich, potato chips, soda", "caesar salad, iced tea", "grilled chicken wrap, fries, lemonade")),
            new Meal("dinner", Arrays.asList("spaghetti and meatballs, red wine", "filet mignon, baked potato, green beans, beer", "grilled salmon, white wine")));

    public List<Meal> getAllMeals() {
        return meals;
    }
}

@RestController
@RequestMapping(path = "/api/v1/meal")
class MealController {
    private MealService mealService;

    public MealController() {
        MealStorage mealStorage = new MealStorage();
        MealRepository mealRepository = new MealRepository(mealStorage);
        this.mealService = new MealService(mealRepository);
    }
    @GetMapping("/breakfast")
    public List<String> getBreakfastCombos() {
        return mealService.getMealCombinations("breakfast");
    }
    @GetMapping("/lunch")
    public List<String> getLunchCombos() {
        return mealService.getMealCombinations("lunch");
    }
    @GetMapping("/dinner")
    public List<String> getDinnerCombos() {
        return mealService.getMealCombinations("dinner");
    }
}

class MealService {
    private MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }
    public List<String> getMealCombinations(String mealType) {
        return mealRepository.getMealCombinations(mealType);
    }
}
