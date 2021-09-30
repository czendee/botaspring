package com.youtochi.botas001.api.controller;

import com.youtochi.botas001.model.FuenteDatos;
import com.youtochi.botas001.model.DbFuenteDatos;
import com.youtochi.botas001.model.FuenteDatosRequest;
import com.youtochi.botas001.model.Librito;
import com.youtochi.botas001.model.CardRedis;
import com.youtochi.botas001.repository.CardRedisRepository;
import com.youtochi.botas001.service.FuenteDatosService;
import com.youtochi.botas001.service.DbFuenteDatosService;
import com.youtochi.botas001.service.KafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.youtochi.botas001.model.StudentTest;
import com.youtochi.botas001.repository.StudentTestRepository;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import java.util.Map;
import java.util.Iterator;
import java.util.Set;


//import org.springframework.data.redis.core.RedisTemplate;
//import com.youtochi.botas001.RedisConfig.RedisConnectionFactory;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.connection.RedisConnection;

@RestController
@RequestMapping("/v1/api")
public class LibroRestController {
  
  @GetMapping(value = { "/librojson" },
              produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Librito traeLibrojson(@RequestParam(name="nombre", required=false, defaultValue="falto el valor") String dos){
    System.out.println("LibroRestController --- traeLibrojson llamado ...4");
    Librito silibro= new Librito("carlos zendejas","489.00");
    // return "{'aa':'bb'}";
    return silibro;
  }
  
  @GetMapping(value = { "/listalibrojson" },
              produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List traeListaLibrojson(@RequestParam(name="nombre", required=false, defaultValue="falto el valor") String dos){
    System.out.println("LibroRestController --- traeListaLibrojson llamado ...4");
    Librito silibro= new Librito("carlos zendejas","489.00");
    Librito silibro2= new Librito("carlos zendejas","489.00");
    List lalista = new ArrayList();
    // return "{'aa':'bb'}";
    lalista.add(silibro);
    lalista.add(silibro2);
    return lalista;
  }
  
  @GetMapping(value = { "/listalibrotext" },
              produces = MediaType.TEXT_PLAIN_VALUE)
  @ResponseBody
  public String traeListaLibrotext(@RequestParam(name="nombre", required=false, defaultValue="falto el valor") String dos){
    System.out.println("LibroRestController --- traeListaLibrotext llamado ...5");
    Librito silibro= new Librito("carlos zendejas","489.00");
    Librito silibro2= new Librito("carlos i zendejas","489.00");
    List lalista = new ArrayList();
    // return "{'aa':'bb'}";
    lalista.add(silibro);
    lalista.add(silibro2);
    return lalista.toString();
  }
  
  @Autowired
  private FuenteDatosService fuenteDatosService;
  
    @Autowired
  private DbFuenteDatosService dbFuenteDatosService;
  
  @RequestMapping(value={"fuente.json","fuente"},
                  method=RequestMethod.POST,
                  consumes ={"application/json","application/xml"},
                  produces={"application/json"}
                 )
  public FuenteDatos obtenFuenteDatosJson(@RequestBody FuenteDatosRequest fuenteDatosRequest){
    System.out.println("LibroRestController --- obtenFuenteDatosJson llamado ...5");
    return this.fuenteDatosService.encuentraLaFuenteDatos(fuenteDatosRequest.getLogin(),fuenteDatosRequest.getPassword());
  }
  
  @RequestMapping(value={"fuente.xml"}, 
                  method=RequestMethod.POST,
                  consumes ={"application/json","application/xml"},
                  produces={"application/xml"}
                 )
  public FuenteDatos obtenFuenteDatosXml(@RequestBody FuenteDatosRequest fuenteDatosRequest){
    System.out.println("LibroRestController --- obtenFuenteDatosXml llamado ...5");
    return this.fuenteDatosService.encuentraLaFuenteDatos(fuenteDatosRequest.getLogin(),fuenteDatosRequest.getPassword());
  }
  
  /// mongo
  
  @GetMapping("/dbfuentes")
  public ResponseEntity<?> getAllFuentes( ){
      Map<String,Object> response = new HashMap <String, Object>();
      List<DbFuenteDatos> fuentes = this.dbFuenteDatosService.findAll();
      response.put("fuentesdatos",fuentes);
      return new ResponseEntity< Map <String,Object>> (response,HttpStatus.OK );
  }
 
    /// redis
  @Autowired
  private CardRedisRepository cardRedisRespository;
  
  @GetMapping("/rediscards")
  public ResponseEntity<?> getAllCards( ){
      Map<String,Object> response = new HashMap <String, Object>();
//      List<CardRedis> fuentes = this.cardRedisRespository.findAll();
    //set a new list
         List<CardRedis> fuentes= new ArrayList();
    //the results are obtained in a iterable
    //and each one of them are added into the new list
         cardRedisRespository.findAll().forEach(fuentes::add);
    
         response.put("tarjetas",fuentes);
        return new ResponseEntity< Map <String,Object>> (response,HttpStatus.OK );
    
    
      //  List<Student> students = new ArrayList<>();
      //studentRepository.findAll().forEach(students::add);
  }
  
//  private final RedisTemplate<String, String> redisTemplate;
//    private  RedisTemplate<String, String> redisTemplate;

//  	@Autowired
//	private miofriojol  myBean;
	 @Autowired
	private RedisTemplate<String, String> redisTemplate;
  
  @GetMapping("/redislistacards")
  public ResponseEntity<?> getAllCardsList( ){
      Map<String,Object> response = new HashMap <String, Object>();
	  List<Object> fuentes= new ArrayList();

      RedisConnection   redisConnection = null;
    try {
      
//       redisConnection = redisTemplate.getConnection();
	 redisConnection = redisTemplate.getConnectionFactory().getConnection();
        ScanOptions options = ScanOptions.scanOptions().match("*card*").count(100).build();

        Cursor c = redisConnection.scan(options);
        while (c.hasNext()) {
            System.out.println(new String((byte[]) c.next()));
        }
	    
Set<String> allAvailableKeys = redisTemplate.keys("*");
Iterator<String> iterator = allAvailableKeys.iterator();
while (iterator.hasNext()) {
       String key= iterator.next();
	System.out.println(key);
       
}	    
	    
	    
       
		    
	    
//Map<Object,Object> map = template.opsForHash().entries("*card*");
//	    value = map.get("1");
Map<Object,Object> map = redisTemplate.opsForHash().entries("#scrumblr#-room:/luna50-cards");	    

// classic way, loop a Map
	for (Map.Entry<Object, Object> entry : map.entrySet()) {
		String algo1 = (String) entry.getKey();
		String algo2 = (String) entry.getValue();
//		System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		System.out.println("Key : " + algo1 + " Value : " + algo2);
		fuentes.add(algo2);		
	}	    
	    
	    
    } finally {
        redisConnection.close(); //Ensure closing this connection.
    }	    
      response.put("tarjetones",fuentes);
      
     return new ResponseEntity< Map <String,Object>> (response,HttpStatus.OK );
  }  
  
	
	  @GetMapping("/redisallroomsallcards")
  public ResponseEntity<?> getAllRoomsAllCardsList( ){
      Map<String,Object> response = new HashMap <String, Object>();
	  //List<Object> fuentes= new ArrayList();
          Map<String,Object> fuentes = new HashMap <String, Object>();
      RedisConnection   redisConnection = null;
    try {
      
//       redisConnection = redisTemplate.getConnection();
	 redisConnection = redisTemplate.getConnectionFactory().getConnection();
        ScanOptions options = ScanOptions.scanOptions().match("*card*").count(100).build();

        Cursor c = redisConnection.scan(options);
        while (c.hasNext()) {
		String cualRoom =new String((byte[]) c.next());
                System.out.println(cualRoom);
		
		Map<Object,Object> map = redisTemplate.opsForHash().entries(cualRoom);	    
                
		List<Object> jsonroom= new ArrayList();
		// classic way, loop a Map
		for (Map.Entry<Object, Object> entry : map.entrySet()) {
			String algo1 = (String) entry.getKey();
			String algo2 = (String) entry.getValue();
	//		System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
			System.out.println("Key : " + algo1 + " Value : " + algo2);
			jsonroom.add(algo2);
					
		}
		
		//fuentes.put("cualRoom",jsonroom);
		fuentes.put(cualRoom,jsonroom);
        }
	    
	    
    } finally {
        redisConnection.close(); //Ensure closing this connection.
    }	    
      response.put("rooms",fuentes);
      
     return new ResponseEntity< Map <String,Object>> (response,HttpStatus.OK );
  }  

	
@GetMapping("/redisroomallcards/{room}")
  public ResponseEntity<?> getAllRoomsAllCardsList(@PathVariable(name = "room") String room ){
      Map<String,Object> response = new HashMap <String, Object>();
	  //List<Object> fuentes= new ArrayList();
          Map<String,Object> fuentes = new HashMap <String, Object>();
      RedisConnection   redisConnection = null;
    try {
      
//       redisConnection = redisTemplate.getConnection();
	 redisConnection = redisTemplate.getConnectionFactory().getConnection();
        ScanOptions options = ScanOptions.scanOptions().match(room).count(100).build(); //use the input parameter room to validate the room exists

        Cursor c = redisConnection.scan(options);
        while (c.hasNext()) {
		String cualRoom =new String((byte[]) c.next());
                System.out.println(cualRoom);
		
		Map<Object,Object> map = redisTemplate.opsForHash().entries(cualRoom);	    
                
		List<Object> jsonroom= new ArrayList();
		// classic way, loop a Map
		for (Map.Entry<Object, Object> entry : map.entrySet()) {
			String algo1 = (String) entry.getKey();
			String algo2 = (String) entry.getValue();
	//		System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
			System.out.println("Key : " + algo1 + " Value : " + algo2);
			jsonroom.add(algo2);
					
		}
		
		//fuentes.put("cualRoom",jsonroom);
		fuentes.put(cualRoom,jsonroom);
        }
	    
	    
    } finally {
        redisConnection.close(); //Ensure closing this connection.
    }	    
      response.put("rooms",fuentes);
      
     return new ResponseEntity< Map <String,Object>> (response,HttpStatus.OK );
  }  

	
      @Autowired
     private StudentTestRepository studentRepository;
  

    @PostMapping("/students")
    public ResponseEntity<StudentTest> createStudent(@RequestBody StudentTest student) {
        StudentTest savedStudent = studentRepository.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<StudentTest> updateStudent(@PathVariable(name = "id") String id, @RequestBody StudentTest student) {
        Optional<StudentTest> std = studentRepository.findById(id);
        if (std.isPresent()) {
            StudentTest studentDB = std.get();
//            studentDB.setGrade(student.getGrade());
//            studentDB.setName(student.getName());
            StudentTest updatedStudent = studentRepository.save(studentDB);
            return new ResponseEntity<>(updatedStudent, HttpStatus.CREATED);
        }
        return null;
    }
    
    @GetMapping("/students")
    public ResponseEntity<List<StudentTest>> getStudents() {
        List<StudentTest> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") String id) {
        studentRepository.deleteById(id);
        return new ResponseEntity<>("Student with id:" + id + " deleted successfully", HttpStatus.OK);
    }
  
      @Autowired
      private KafkaProducer producerService;
  
    @PostMapping(value = "/publishstudent")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
       this.producerService.sendMessage(message);
    }
  
      @GetMapping(value = "/publishstudentget")
    public void sendMessageToKafkaTopicGet(@RequestParam("message") String message) {
       this.producerService.sendMessage(message);
    }
  
}
