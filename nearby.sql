drop schema if exists `DistanceFinder`;
create schema `DistanceFinder`;
use `DistanceFinder`;

CREATE TABLE `markers` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `name` VARCHAR( 60 ) NOT NULL ,
  `address` VARCHAR( 80 ) NOT NULL ,
  `lat` decimal( 10, 6 ) NOT NULL ,
  `lng` decimal( 10, 6 ) NOT NULL
) ENGINE = InnoDB ;

select * from markers;

INSERT INTO `markers` (`name`, `address`, `lat`, `lng`) VALUES ('Frankie Johnnie & Luigo Too','939 W El Camino Real, Mountain View, CA','12.833797','77.692862');
INSERT INTO `markers` (`name`, `address`, `lat`, `lng`) VALUES ('Amici\'s East Coast Pizzeria','790 Castro St, Mountain View, CA','12.917858','77.624524');
INSERT INTO `markers` (`name`, `address`, `lat`, `lng`) VALUES ('Kapp\'s Pizza Bar & Grill','191 Castro St, Mountain View, CA','12.971891','77.641154');
INSERT INTO `markers` (`name`, `address`, `lat`, `lng`) VALUES ('Round Table Pizza: Mountain View','570 N Shoreline Blvd, Mountain View, CA','12.925453','77.546757');

SELECT 
id,
(
   3959 *
   acos(cos(radians(37)) * 
   cos(radians(lat)) * 
   cos(radians(lng) - 
   radians(-122)) + 
   sin(radians(37)) * 
   sin(radians(lat )))
) AS distance 
FROM markers 
HAVING distance < 25 
ORDER BY distance LIMIT 0, 20;

-- Complete SQL Query 2------------------------------------
SELECT id, address, lat, lng, distance
  FROM (
 SELECT z.id,
        z.lat, z.lng, z.address,
        p.radius,
        p.distance_unit
                 * DEGREES(ACOS(COS(RADIANS(p.latpoint))
                 * COS(RADIANS(z.lat))
                 * COS(RADIANS(p.longpoint - z.lng))
                 + SIN(RADIANS(p.latpoint))
                 * SIN(RADIANS(z.lat)))) AS distance 
  FROM markers AS z
  JOIN (   /* these are the query parameters -- Radius specifies the kilometer bound near by that point */
        SELECT  12.913367  AS latpoint,  77.624627 AS longpoint,
                50.0 AS radius,      111.045 AS distance_unit
    ) AS p
  WHERE z.lat
     BETWEEN p.latpoint  - (p.radius / p.distance_unit)
         AND p.latpoint  + (p.radius / p.distance_unit)
    AND z.lng
     BETWEEN p.longpoint - (p.radius / (p.distance_unit * COS(RADIANS(p.latpoint))))
         AND p.longpoint + (p.radius / (p.distance_unit * COS(RADIANS(p.latpoint))))
 ) AS d
 WHERE distance <= radius
 ORDER BY distance
 LIMIT 15;
 
 -- SQL Query 3 ---------------------------
 SELECT lat, lng, SQRT(
    POW(69.1 * (lat - 12.913367), 2) +
    POW(69.1 * (77.624627 - lng) * COS(lat / 57.3), 2)) AS distance
FROM markers HAVING distance < 25 ORDER BY distance;