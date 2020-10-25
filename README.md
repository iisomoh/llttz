# TABLE OF CONTENT

- [TABLE OF CONTENT](#table-of-content)
- [DOCUMENTATION](#documentation)
  - [TEST CASE #1](#test-case-1)
  - [TEST CASE #2](#test-case-2)
  - [TEST CASE #3](#test-case-3)
  - [TEST CASE #4](#test-case-4)
  - [TEST CASE #5](#test-case-5)
  - [TEST CASE #6](#test-case-6)
  - [TEST CASE #7](#test-case-7)
  - [TEST CASE #8](#test-case-8)
  - [TEST CASE #9](#test-case-9)
  - [TEST CASE #10](#test-case-10)

# DOCUMENTATION
## TEST CASE #1
**Name of the test case:** testGetTimeZone()

**Goal of the test case:** to check whether we get correct timezone

**Characteristics:**

  - C1(Interface-based): latitude is double
  - C2(Interface-based): longitude is double
  - C3(Functionality-based): lat, long falls into continent and oceans in tz database classification 
  
**Input domain modelling:**

**1. Identify testable functions:** `getTimeZone()` `from Converter.java`
   
**2. Identify parameters, return types, return values, and exceptional behaviors**

    1. Parameters: double lat, double lon
    2. Return types: TimeZone
    3. Return values: TimeZone object of the nearest value
    4. Exceptional behavior: -
   
**3. Model the input domain**
	
| Characteristics | b1     | b2      | b3         | b4     | b5   | b6       | b7        | b8     | b9     | b10     |
|-----------------|--------|---------|------------|--------|------|----------|-----------|--------|--------|---------|
| C1              | True   | False   |            |        |      |          |           |        |        |         |
| C2              | True   | False   |            |        |      |          |           |        |        |         |
| C3              | Africa | America | Antarctica | Arctic | Asia | Atlantic | Australia | Europe | Indian | Pacific |

**4. Approach :** ECC = 10 test cases 

	(true, true, Africa), (false, false, America), (true, false, Antarctica), (false, true, Arctic), 
	(false, false, Asia), (true, true, Atlantic), (true, false, Australia), (false, false, Europe), 
	(true, true, Indian), (false true, Pacific)

**5. Derive test values and expected value**
   
| Test cases                   	|    lat    	|    lon   	| Expected Result 	|
|------------------------------	|:---------:	|:--------:	|:---------------:	|
| T1(true, true, Africa)       	|  15.33333 	| 38.88333 	|      Africa     	|
| T2 (false, false, America)   	|    null   	|   null   	|      Error      	|
| T3 (true, false, Antarctica) 	| -68.58334 	|    15    	|      Error      	|
| T4 (false, true, Arctic)     	|     -9    	| 16.21547 	|      Error      	|
*Note : Other test cases are duplicated.

[Back to Top](#tableofcontent)

---
## TEST CASE #2
**Name of the test case:** testLocation()

**Goal of the test case:** To validate the Location is initialized successfully or not

**Characteristics:**

  - C1(Interface-based): string is null
  - C4(Functionality-based): latitude, longitude fall in its range

*Note: Latitudes range from -90 to 90, and longitudes range from -180 to 80.

**Input domain modelling:**

**1. Identify testable functions:** `Location(final double latitude, final double longitude, final String zone)` `from Location.java`
   
**2. Identify parameters, return types, return values, and exceptional behaviors**

    1. Parameters: double lat, double lon, string zone
    2. Return types: Location
    3. Return values: Not null
    4. Exceptional behavior: -
   
**3. Model the input domain**
	
| Characteristics                                                                   	|  b1  	|   b2  	|
|-----------------------------------------------------------------------------------	|:----:	|:-----:	|
| C1 = string is null                                                               	| True 	| False 	|
| C2 =  latitude, longitude fall in its range *(lat : -90 to 90, lon : -180 to 180) 	| True 	| False 	|

**4. Approach :** BCC  = 1 + (2-1) + (2-1) = 3 Test case

	Base choice : (True, True)
	(True, False)
	(False, True)

**5. Derive test values and expected value**

| Test cases       	|  lat  	|    lon    	|     zone     	|                                Expected result                                	|
|------------------	|:-----:	|:---------:	|:------------:	|:-----------------------------------------------------------------------------:	|
| T1 (True, True)  	|   90  	|    -180   	|     null     	|                                     Error                                     	|
| T2 (True, False) 	|  -99  	|    189    	|     null     	|                                     Error                                     	|
| T3 (False, True) 	| 13.75 	| 100.51666 	| Asia/Bangkok 	| Location object created with Coord [13.75, 100.51666] and Zone [Asia/Bangkok] 	|

[Back to Top](#tableofcontent)

---
## TEST CASE #3
**Name of the test case:** testConverterInitialization()

**Goal of the test case:** Test that converter is initialized successfully or not

**Characteristics:**

  - C1(Interface-based): class file is empty
  - C2(Interface-based): class file is extends from TimeZoneStore
  - C3(Functionality-based): class classification
  
**Input domain modelling:**

**1. Identify testable functions:** `Converter(Class clazz)` `from Converter.java`
   
**2. Identify parameters, return types, return values, and exceptional behaviors**

    1. Parameters: Class file
    2. Return types: Converter Object
    3. Return values: -
    4. Exceptional behavior: InstantiationException | IllegalAccessException
   
**3. Model the input domain**
	
| Characteristics                               	|         b1        	|         b2        	|   b3  	|
|-----------------------------------------------	|:-----------------:	|:-----------------:	|:-----:	|
| C1 = class file is empty                      	|        True       	|       False       	|   -   	|
| C2 = class file is extends from TimeZoneStore 	|        True       	|       False       	|   -   	|
| C3 = class classification                     	| TimeZoneListStore 	| TimeZoneTreeStore 	| Other 	|

**4. Approach :** ACoC = C1\*C2\*C3 =2\*2\*3 = 12 Test cases 

    1. (True, True, TimeZoneListStore), 
    2. (True, True, TimeZoneTreeStore), 
    3. (True, True, Other),
    4. (True, False, TimeZoneListStore), 
    5. (True, False, TimeZoneTreeStore), 
    6. (True, False, Other),
    7. (False, True, TimeZoneListStore), 
    8. (False, True, TimeZoneTreeStore),
    9. (False, True, Other),
    10. (False, False, TimeZoneListStore), 
    11. (False, False, TimeZoneTreeStore),
    12. (False, False, Other)

**5. Derive test values and expected value**

| Test cases                            	| Class file isEmpty 	| Class file isExtend 	|       Clazz       	|               Expected result              	|
|---------------------------------------	|:------------------:	|:-------------------:	|:-----------------:	|:------------------------------------------:	|
| T1 (True, True, TimeZoneListStore)    	|        True        	|         True        	| TimeZoneListStore 	|               Infeasible Test              	|
| T2 (True, True, TimeZoneTreeStore)    	|        True        	|         True        	| TimeZoneTreeStore 	|               Infeasible Test              	|
| T3 (True, True, invalid)              	|        True        	|         True        	|       Other       	|               Infeasible Test              	|
| T4 (True, False, TimeZoneListStore)   	|        True        	|        False        	| TimeZoneListStore 	|               Infeasible Test              	|
| T5 (True, False, TimeZoneTreeStore)   	|        True        	|        False        	| TimeZoneTreeStore 	|               Infeasible Test              	|
| T6 (True, False, invalid)             	|        True        	|        False        	|       Other       	|               Infeasible Test              	|
| T7 (False, True, TimeZoneListStore)   	|        False       	|         True        	| TimeZoneListStore 	|             Success Initialize             	|
| T8 (False, True, TimeZoneTreeStore)   	|        False       	|         True        	| TimeZoneTreeStore 	|             Success Initialize             	|
| T9 (False, True, invalid),            	|        False       	|         True        	|       Other       	|             Success Initialize             	|
| T10 (False, False, TimeZoneListStore) 	|        False       	|        False        	| TimeZoneListStore 	|               Infeasible Test              	|
| T11 (False, False, TimeZoneTreeStore) 	|        False       	|        False        	| TimeZoneTreeStore 	|               Infeasible Test              	|
| T12 (False, False, invalid)           	|        False       	|        False        	|       Other       	| Throw Exception “IllegalArgumentException” 	|

[Back to top](tableofcontent)

---
## TEST CASE #4
**Name of the test case:** testDistanceInKilometers()

**Goal of the test case:** To validate the distance calculation in kilometers between difference locations

**Characteristics:**

- C1(Interface-based): from-location is null
- C2(Interface-based): to-location is null
- C3(Functionality-based): from-location is differences to to-location

**Input domain modelling:**

**1. Identify testable functions:** `distanceInKilometers(final Location from, final Location to)` `from TimeZoneStore.java`
   
**2. Identify parameters, return types, return values, and exceptional behaviors**

    1. Parameters: Location from, Location to
    2. Return types: double
    3. Return values: return kilometers distance between 2 locations
    4. Exceptional behavior: -
   
**3. Model the input domain**
	
| Characteristics                                  	| b1   	| b1    	|
|--------------------------------------------------	|------	|-------	|
| C1 = from-location is null                       	| True 	| False 	|
| C2 = to-location is null                         	| True 	| False 	|
| C3 = from-location is differences to to-location 	| True 	| False 	|


**4. Approach :** BCC = 1(1) + (2-1) + (2-1) + (2-1) = 4 Test cases

    Base choice : (False, False, False)
    (True, False, False)
    (False, True , False)
    (False, False, True)

**5. Derive test values and expected value**

| Test cases                            	| Location from isNull                  | Location to isNull 	            |      Expected result   |
|---------------------------------------	|:----------------------------------:   |:-----------------------:	        |:----------------------:|
| T1 (False, False, False )    	            |    (lat 13.7946584, lon 100.2883976)  | (lat 13.731967, lon 100.3565472)  |           10.14        |
| T2 (True, True, False)                	|                   null        	    |         null        	            |           Error        |
| T3 (False, True, True)                 	|            (lat 23, lon 34)           |         null        	            |           Error        |
| T4 (True, False, True)                  	|                  null        	        |    (lat 23, lon 34) 	            |           Error        |

[Back to top](tableofcontent)

---
## TEST CASE #5 
**Name of the test case:** testCentralAngle()

**Goal of the test case:** Test that program can calculate angle between lat,long correctly

**Characteristics:**
-C1(Interface-based): Every input value is not null
-C2(Functionality-based): differences between lat,lon from and lat,lon to

**Input domain modelling:**

**1. Identify testable functions:** `centralAngle(final double latFrom, final double lonFrom, final double latTo, final double lonTo)` `from TimeZoneStore.java`
   
**2. Identify parameters, return types, return values, and exceptional behaviors**

    1. Parameters: double latFrom, double lonFrom, double latTo, double lonTo
    2. Return types: double
    3. Return values: distance between lat,long from 2 places in angle 
    4. Exceptional behavior: -
   
**3. Model the input domain**
	
| Characteristics                                      	|   b1   	                        |   b2  	                          |
|------------------------------------------------------	|:--------------------------:	    |:--------------------------------:	  |
| C1 = Every input value is not null                    |  True                             | False                               | 
| C2 = differences between lat,lon from and lat, lon to |  Same location(difference = 0) 	| Difference location(difference > 0) |

**4. Approach :** MBCC = 2 + (2*(2-2)) + (2*(2-1)) = 2+0+2 = 4 Test cases

    Base choice : 
    1. (True, difference = 0)
	    (True, difference > 0)
    2. (False, difference = 0)
	    (False,  difference > 0)

**5. Derive test values and expected value**
| Test case                   | latFrom     | lonFrom     | latTo      | lonTo        | Expected Result |
| :-------------------------: |:--------:   | :--------:  | :--------: | :--------:   | :------:        |
| T1(True, difference = 0)    | 13.7946584  | 100.2883976 | 13.7946584 | 100.2883976  | 0               |
| T2(False, difference = 0)   | null        | null        | null       | null         | Error           |
| T3(True, difference > 0)    | 13.7946584  | 100.2883976 | 13.731967  | 100.3565472  | 0.091           |
| T4 duplicated with T2       |

[Back to top](tableofcontent)

---
## TEST CASE #6 
**Name of the test case:** testHypersphereAndHyperplaneIntersection()

**Goal of the test case:** to check whether the we have nearest location

**Characteristics:**

- C1(Interface-based): coord1 is double
- C2 (Interface-based): coord2 is double
- C3(Functionality-based): Distance between coord1 and coord2

**Input domain modelling:**

**1. Identify testable functions:** `hypersphereAndHyperplaneIntersection(final double coord1, final double coord2, final double bestDistance)` `from TimeZoneTreeStore.java`
   
**2. Identify parameters, return types, return values, and exceptional behaviors**

    1. Parameters: double coord1, double coord2, double bestDistance
    2. Return types: Boolean
    3. Return values: If diff < 180, return (diff < bestDistance),else ((360.0 - diff) < bestDistance)
    4. Exceptional behavior: -
   
**3. Model the input domain**
	
| Characteristics 	|        b1       	|        b2       	|        b3       	|
|-----------------	|:---------------:	|:---------------:	|:---------------:	|
| C1              	|       True      	|      False      	|                 	|
| C2              	|       True      	|      False      	|                 	|
| C3              	| coord1 > coord2 	| coord1 = coord2 	| coord2 > coord1 	|

**4. Approach :** MBCC = 2 + (2\*(2-2)) + (2\*(2-1)) + (2\*(3-1))  = 2 + 0 + 2 + 4 = 8 Test cases

    Base choice:
    1. (True, True, coord1 > coord2)
        (True, False, coord1 > coord2),
        (True, True, coord1 = coord2),
        (True, True, coord2 > coord1),

    2. (False, True, coord1 > coord2)
        (False, False, coord1 > coord2),
        (False, True, coord1 = coord2),
        (False, True,  coord2 > coord1),

**5. Derive test values and expected value** 

| Test cases                            | coord1             	| coord2 	            |   bestDistance      	|        Expected result           	|
|---------------------------------------|:------------------:	|:-------------------:	|:-----------------:	|:-----------------------------:    |
| T1 (True, True, coord1 > coord2)    	|       13.7946584      |      13.731967        |          0.091 	    |               True              	|
| T2 (True, False, coord1 > coord2)    	|       13.7946584      |         1        	    |          0.091 	    |               Error              	|
| T3 (True, True, coord1 = coord2)      |       13.7946584      |      13.7946584       |           0.0       	|               False              	|
| T4  (True, True, coord2 > coord1)   	|       13.731967       |      13.7946584       |          0.091 	    |               True              	|
| T5 (False, True, coord1 > coord2)   	|          15        	|      13.731967        |          0.091 	    |               Error              	|
| T6 (False, False, coord1 > coord2)    |          15        	|         13        	|          0.091       	|               Error              	|
| T7 (False, True, coord1 = coord2)   	|          15       	|      15.00000        	|           0 	        |               Error             	|
| T8 (False, True, coord2 > coord1)   	|          13       	|      13.7946584       |          0.091 	    |               Error               |

[Back to top](tableofcontent)

---
## TEST CASE #7 
**Name of the test case:** testInsert()

**Goal of the test case:** To test wheter we can insert a node to the tree

**Characteristics:**

- C1(Interface-based): loc is null
- C2(Functionality-based): Position of the input node correspond to its parent
  
**Input domain modelling:**

**1. Identify testable functions:** `insert(Location loc)` `from TimeZoneTreeStore.java`
   
**2. Identify parameters, return types, return values, and exceptional behaviors**

    1. Parameters: loc
    2. Return types: -
    3. Return values: -
    4. Exceptional behavior: -
   
**3. Model the input domain**
	
| Characteristics                                          			|  b1  	    |   b2  	|  
|------------------------------------------------------------	    |:--------:	|:---------:|
| C1 = loc is null                                         			| True 	    | False 	|      	
| C2 = position of the input node correspond to its parent 	        | True 	    | False 	|

**4. Approach :** 
ECC = max{C1,C2} = max{2,2} = 2 Test cases
(False, True) , (False, False)

**5. Derive test values and expected value** 
| Test case		        | 		Loc 		                                |    Expected Result            |
|------------------    	|:-----------------------------------------------:  |   :-----------------------:	|
|T1(True, Left)      	| Location[5.3166, -4.03334, “Africa/Abidjan”]      |   Duplicated error  	        |
|T2(True, Right)   	    | Location[5.3166, -4.03334, “Africa/Abidjan”]      |   Size of list should be 1	|

[Back to top](tableofcontent)

---
## TEST CASE #8 
**Name of the test case:** testNearestTimeZoneTreeStore()

**Goal of the test case:** To test whether the program return the nearest timezone

**Characteristics:**

- C1(Interface-based): searchLocation is null
- C2(Functionality-based): right node of this tree is equal to the input

**Input domain modelling:**

**1. Identify testable functions:** `nearestTimeZone(final Location searchLocation)` `from TimeZoneTreeStore.java`
   
**2. Identify parameters, return types, return values, and exceptional behaviors**

    1. Parameters: searchLocation
    2. Return types: TimeZone Object
    3. Return values: TimeZone name
    4. Exceptional behavior: -
   
**3. Model the input domain**
	
| Characteristics             	|  b1  	|   b2  	|
|-----------------------------	|:----:	|:-----:	|
| C1 = searchLocation is null 	| True 	| False 	|
| C2 =  TimeZone is found     	| True 	| False 	|

**4. Approach :** ECC = max{C1,C2} = max{2,2} = 2

1. (True, True) 
2. (True, False)

**5. Derive test values and expected value** 

| Test Cases        |  searchLocation       | Expected result       |
| :---------------:	| :-----------------:	| :-----------------:	|
| T1 (True,True)  	|        xx       	|      xxxx      	|
| T2 (True, False)	|        xx       	|       xx    	|
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

[Back to top](tableofcontent)

---
## TEST CASE #9 // not finish
**Name of the test case:** testNearestTimeZone()

**Goal of the test case:** Test whether the location has the nearest timezone

**Characteristics:**

- C1(Interface-based): Location is null
- C2(Functionality-based):  bestGuess zone is the first member or not
  
**Input domain modelling:**

**1. Identify testable functions:** `nearestTimeZone(final Location node)` `from TimeZoneListStore.java`
   
**2. Identify parameters, return types, return values, and exceptional behaviors**

    1. Parameters: Location node
    2. Return types: TimeZone
    3. Return values: The best guess TimeZone object 
    4. Exceptional behavior: -
   
**3. Model the input domain**
	
| Characteristics                                  	|  b1  	|   b2  	|
|--------------------------------------------------	|:----:	|:-----:	|
| C1 = Location is null                            	| True 	| False 	|
| C2 =  bestGuess zone is the first member or not  	| True 	| False 	|

**4. Approach :** PWC = 2*2 = 4 test cases

    (True, True) , (True, False) , (False, True) ,(False, False)

**5. Derive test values and expected value** // not finish

[Back to top](tableofcontent)

---
## TEST CASE #10 
**Name of the test case:** testLoadData()

**Goal of the test case:** To test whether program load timezone data from file successfully or not

**Characteristics:**

- C1(Interface-based): file is exists
- C2(Functionality-based): data is loaded into variable tzStore
  
**Input domain modelling:**

**1. Identify testable functions:** `loadData()` `from Converter.java`
   
**2. Identify parameters, return types, return values, and exceptional behaviors**

    1. Parameters: -
    2. Return types: void 
    3. Return values: -
    4. Exceptional behavior: IllegalArgumentException, InstantiationException
   
**3. Model the input domain**
	
| Characteristics                            	|  b1  	|   b2  	|
|--------------------------------------------	|:----:	|:-----:	|
| C1 = file is exists                        	| True 	| False 	|
| C2 =  data is loaded into variable tzStore 	| True 	| False 	|

**4. Approach :** PWC = 2*2 = 4 test cases

    1. (True, True) ,
    2. (True, False) , 
    3. (False, True) ,
    4. (False, False)

**5. Derive test values and expected value** 
| Test Cases                    | Expected result  	                |
| :-------------------------:	| :----------------------------:	|
| T1 (True, True)               | tzStore is not null 	            |
| T2 (True, False) 	            | tzStore is null	                |
| T3 (False, True)              | Infeasible test 	                |
| T4 (False, False) 	        | throw IllegalArgumentException	|

[Back to top](tableofcontent)
