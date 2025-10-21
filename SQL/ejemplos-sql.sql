SELECT * | [DISTINCT] COLUMN1, COLUMN2 [ [AS] ALIAS ] , ...
FROM tabla/s
[WHERE condicion/es]
[GROUP BY columna1, [columna2, ...]]
[HAVING condicion/es] 
[ORDER BY columna1 | expresión1 | alias1 [[ASC] | [DESC]] [, columna2 | expresión2 | alias2 [[ASC] | [DESC]], ... ]];

-- mostrar tablas de la bbdd "training"
SHOW TABLES;

-- describir la estructura de una tabla
DESCRIBE emp;

-- seleccionar todas las columnas de una tabla
SELECT * FROM emp;

-- seleccionar sólo ciertas columnas de la tabla
SELECT empno, ename, job, sal 
FROM emp;

-- uso de DISTINCT (se aplica a la lista completa de columnas)
SELECT DISTINCT job, deptno
FROM emp;

-- usar alias de columnas
SELECT empno AS id, 				-- con la palabra clave "AS"
	   ename AS "Nombre Empleado",  -- comillas dobles cuando el alias tiene caracteres especiales 
	   								-- o cuando queremos respetar mayúsculas y minúsculas
	   job oficio, 					-- sin la palabra clave "AS" (menos legible)
	   sal salario,					-- sin la palabra clave "AS" (menos legible)
	   sal * 14 AS Salario_Anual	-- útil para expresiones	   
FROM emp;

-- uso de ORDER BY
SELECT deptno,
	   empno AS id, 				-- con la palabra clave "AS"
	   ename AS "Nombre Empleado",  -- comillas dobles cuando el alias tiene caracteres especiales 
	   								-- o cuando queremos respetar mayúsculas y minúsculas
	   job oficio, 					-- sin la palabra clave "AS" (menos legible)
	   sal salario,					-- sin la palabra clave "AS" (menos legible)
	   sal * 14 AS Salario_Anual	-- útil para expresiones	   
FROM emp
ORDER BY deptno,     				-- ordenación por departamento ascendente (ascendente por defecto)
		 Salario_Anual DESC;		-- ordenación adicional por alias de columna (descendente)

-- ejemplos cláusula WHERE
		 
SELECT * 
FROM emp
WHERE sal >= 2000;

-- Operadores de comparación

-- operador							significado
-- ------------------------------------------------------------------------
-- =								igual que
-- <								menor que
-- <=								menor o igual que
-- >								mayor que
-- >=								mayor o igual que
-- !=								distinto de
-- [NOT] IN (e1,e2,e3,...)			cualquiera de los valores de la lista
-- [NOT] BETWEEN valor1 AND valor2	entre ambos valores (inclusive)
-- [NOT] LIKE 'patrón'				coincidencia con un patrón determinado
-- IS [NOT] NULL					coincidencia con valores nulos

-- recuperar nombre, oficio, salario y departamento de 
-- todos los empleados que no trabajen en el departamento 20
-- y ordenar los registros por salario descendente

SELECT deptno, ename, job, sal
FROM emp
WHERE deptno != 20
ORDER BY sal DESC;

-- ejemplo IN
SELECT deptno, ename, job, sal
FROM emp
WHERE deptno IN (10,20);

-- ejemplo BETWEEN
SELECT deptno, ename, job, sal
FROM emp
WHERE sal BETWEEN 1500 AND 2200;

-- ejemplo LIKE
-- % INDICA 0 O N CARACTERES
SELECT deptno, ename, job, sal
FROM emp
WHERE lower(ename) LIKE 't%';

-- _ INDICA 1 ÚNICO CARACTER

SELECT deptno, ename, job, sal
FROM emp
WHERE lower(ename) LIKE '_u%';

-- recuperar empleados con manager NULL

SELECT * 
FROM emp
WHERE mgr = NULL;  -- no devuelve ninguna fila

SELECT * 
FROM emp
WHERE mgr IS NULL; -- ahora sí devuelve filas

-- si se cuela un valor NULL en expresiones aritméticas 
-- el resultado final será NULL

SELECT sal * 14 + NULL
FROM emp;

-- calcular el salario total anual de los empleados
SELECT ename, sal, comm, (sal + comm) * 14 AS "Salario Anual" 
FROM emp;

-- FUNCIONES A NIVEL DE FILA

SELECT ename, lower(ename), upper(ename)
FROM emp;

-- NVL() calcular el salario total anual de los empleados
SELECT ename, sal, nvl(comm, 0), (sal + nvl(comm, 0)) * 14 AS "Salario Anual" 
FROM emp;

-- encontrar la posición que ocupa la primera letra 'u'
-- en el nombre de los empleados

SELECT ename, instr(ename, 'u')
FROM emp;

-- generar un mensaje del estilo
-- "el empleado 7839 trabaja para el empleado 8876"

SELECT CONCAT('El empleado ', empno, ' trabaja para el empleado ', mgr) AS Mensaje
FROM emp;

-- substr

SELECT substr(ename, 1, 3) as "Primeras 3 letras"
FROM emp;

-- generar emails de empleados

SELECT lower(concat(substr(ename, 1, 3), 
					substr(job, -3, 3), 
					'@dominio.com')) as 'emails'
FROM emp;

-- EJEMPLO DE REDONDEO A DISTINTAS POSICIONES NUMÉRICAS
SELECT  ROUND(12345.6789, 2),
		ROUND(12345.6789, 1),
		ROUND(12345.6789, 0),
		ROUND(12345.6789, -1),
		ROUND(12345.6789, -2);

-- FUNCIONES DE GRUPO

SELECT ROUND(AVG(sal),2), MIN(sal), MAX(sal)
FROM emp;

SELECT COUNT(*), COUNT(DEPTNO), COUNT(DISTINCT DEPTNO)
FROM emp;

-- media de salarios por departamento

-- estamos obligados a agrupar por todas las columnas 
-- seleccionadas que no sean funciones de grupo

SELECT deptno, AVG(sal)
FROM emp
GROUP BY deptno;

SELECT deptno, job, AVG(sal)
FROM emp
GROUP BY deptno, job;

-- calcular media de salarios por departamento y oficio
-- para departamentos distintos al 20

SELECT deptno, job, AVG(sal)
FROM emp
WHERE deptno != 20
GROUP BY deptno, job;

-- calcular media de salarios por departamento y oficio
-- para departamentos distintos al 20
-- siempre que la media de salarios supere 3000

SELECT deptno, job, AVG(sal) as media
FROM emp
WHERE deptno != 20		-- FILTRAR ANTES DE AGRUPAR
GROUP BY deptno, job
HAVING AVG(sal) > 3000;	-- COMO WHERE PARA PREGUNTAR POR FUNCIONES DE GRUPO
	
-- ROLLUP Y CUBE

SELECT deptno, job, AVG(sal) as media
FROM emp
GROUP BY ROLLUP (deptno, job);

SELECT deptno, job, AVG(sal) as media
FROM emp
GROUP BY CUBE (deptno, job);

-- RECUPERAR DATOS DE EMPLEADOS CON SALARIO SUPERIOR AL DE TURNER

-- en lugar de ésto

SELECT sal
FROM emp 
WHERE ename = 'TURNER';

SELECT ename, sal 
FROM emp 
WHERE sal > 1500;

-- una subconsulta lo resuelve:

-- subconsultas de una sola fila
SELECT ename, sal 
FROM emp 
WHERE sal > (SELECT sal
			 FROM emp 
			 WHERE ename = 'TURNER');

-- subconsultas de más de una fila
SELECT ename, sal 
FROM emp 
WHERE sal >ALL (SELECT sal
			 FROM emp 
			 WHERE deptno = 20);

-- RECUPERAR EMPLEADOS CON UN SALARIO SUPERIOR 
-- A LA MEDIA DE SALARIOS DE SU DEPARTAMENTO

-- subconsulta correlacionada
SELECT deptno, ename
FROM emp e
WHERE sal > (SELECT AVG(sal)
			 FROM emp 
			 WHERE deptno = e.deptno);


-- insertar un registro que coincide en salario con un empleado 
-- del departamento 30 y en comisión con un empleado diferente del departamento 30

INSERT INTO emp
VALUES(8001, 'CESAR', 'MANAGER', 100, '1981-02-21', 1600, 500, 10);

-- insertar un registro que coincide en salario y comisión con el mismo
-- registro del departamento 30

INSERT INTO emp
VALUES(8002, 'MARTA', 'CLERK', 100, '1991-03-11', 1250, 500, 10);

COMMIT;
select * from emp where deptno = 30;

-- comprobar diferencia entre dos subconsultas distintas
SELECT deptno, ename, sal, comm
FROM emp 
WHERE sal IN (SELECT sal
			  FROM emp 
			  WHERE deptno = 30)
AND comm IN (SELECT comm
			  FROM emp 
			  WHERE deptno = 30)
AND deptno != 30;

-- y una subconsulta multicolumna
-- (coincidencia exacta con el mismo registro devuelto por la subconsulta)

SELECT deptno, ename, sal, comm
FROM emp
WHERE (sal, comm) IN (SELECT sal, comm
			 		  FROM emp 
			 		  WHERE deptno = 30)
AND deptno != 30;

-- subconsultas en cláusula FROM

SELECT e.deptno, ename, sal, subconsulta.media
FROM emp e, ( SELECT deptno, ROUND(AVG(sal),2) AS media
              FROM emp
              GROUP BY deptno ) subconsulta
WHERE e.deptno = subconsulta.deptno;
 
-- subconsultas con WITH

WITH sub AS (
		SELECT deptno, avg(sal) as media
  	 	FROM emp
  	 	GROUP BY deptno)
SELECT emp.deptno, emp.ename, emp.sal, sub.media
FROM emp, sub
WHERE emp.deptno = sub.deptno
ORDER BY emp.deptno, sal DESC;

-- JOINS

-- 	INNER JOINS (DEVUELVE SOLO COINCIDENCIAS EN AMBAS TABLAS)

--   EQUIJOINS (UNIONES MEDIANTE CAMPOS EQUIVALENTES)

-- sintáxis no estándar mediante condiciones en where
SELECT dname, emp.* 
FROM dept, emp
WHERE dept.deptno = emp.deptno;

--    NATURAL JOIN UNE LAS TABLAS MEDIANTE TODOS LOS CAMPOS
--    QUE TENGAN EL MISMO NOMBRE

SELECT dname, emp.*
FROM dept
NATURAL JOIN emp;

-- USING PERMITE INDICAR LA COLUMNA A USAR PARA RELACIONAR DATOS

SELECT dname, emp.*
FROM dept
JOIN emp
USING (deptno);

-- ON PERMITE CONTROLAR LA CONDICIÓN DE UNIÓN
SELECT dname, emp.*
FROM dept
JOIN emp
ON (dept.deptno = emp.deptno);

-- APLICAR CRITERIOS O FILTROS ADICIONALES
SELECT dname, emp.*
FROM dept
JOIN emp
ON (dept.deptno = emp.deptno
AND dname = 'ACCOUNTING');

-- EQUIVALENTE

SELECT dname, emp.*
FROM dept
JOIN emp
ON (dept.deptno = emp.deptno)
WHERE dname = 'ACCOUNTING';

--   NON EQUIJOINS (UNIONES MEDIANTE CAMPOS NO EQUIVALENTES)

SELECT salgrade.*, ename, sal
FROM emp, salgrade
WHERE emp.sal BETWEEN losal AND hisal;

-- SINTÁXIS ESTÁNDAR

SELECT salgrade.*, ename, sal
FROM emp
JOIN salgrade
ON (emp.sal BETWEEN losal AND hisal);

--  OUTER JOINS (PERMITEN FORZAR LA RECUPERACIÓN DE FILAS
--				 AUNQUE NO EXISTAN COINCIDENCIAS EN LA OTRA TABLA)
--	 LEFT OUTER JOIN
SELECT dname, emp.*
FROM dept
LEFT OUTER JOIN emp
ON (dept.deptno = emp.deptno);

--	 RIGHT OUTER JOIN
-- (necesitamos un registro de emp sin departamento asignado para probarlo)
UPDATE emp SET deptno = NULL
WHERE ename ='CESAR';

COMMIT;

SELECT dname, emp.*
FROM dept
RIGHT OUTER JOIN emp
ON (dept.deptno = emp.deptno);

--   FULL OUTER JOIN (NO SOPORTADO POR MARIADB)
SELECT dname, emp.*
FROM dept
FULL OUTER JOIN emp
ON (dept.deptno = emp.deptno);

-- CROSS JOIN (PRODUCTOS CARTESIANOS)
-- PREPARAR DATOS PARA PROBAR EL CROSS JOIN
DROP TABLE palos;

CREATE TABLE palos (
	ID DECIMAL(1,0) PRIMARY KEY,
	PALO VARCHAR(7)
);

INSERT INTO palos
VALUES(1, 'OROS');

INSERT INTO palos
VALUES(2, 'COPAS');

INSERT INTO palos
VALUES(3, 'ESPADAS');

INSERT INTO palos
VALUES(4, 'BASTOS');

COMMIT;

SELECT * FROM palos;

DROP TABLE cartas;

CREATE TABLE cartas (
	numero_carta DECIMAL(2,0) PRIMARY KEY,
	carta VARCHAR(7)
);
-- SINTÁXIS MULTI-INSERT

INSERT INTO cartas
VALUES(1, 'as'),
	  (2, 'dos'),
	  (3, 'tres'),
	  (4, 'cuatro'),
	  (5, 'cinco'),
	  (6, 'seis'),
	  (7, 'siete'),
	  (8, 'sota'),
	  (9, 'caballo'),
	  (10, 'rey');

COMMIT;

SELECT * FROM cartas;

SELECT concat(carta, ' de ', palo) AS carta
FROM palos, cartas
ORDER BY RAND();

-- SQL ESTÁNDAR
SELECT concat(carta, ' de ', palo) AS carta
FROM palos
CROSS JOIN cartas
ORDER BY RAND();

-- SELF JOINS (UNIÓN DE UNA TABLA CONSIGO MISMA)

SELECT concat(empleado.ename, ' trabaja para ', manager.ename)
FROM emp empleado, emp manager
WHERE empleado.mgr = manager.empno;

-- SQL ESTÁNDAR

SELECT concat(empleado.ename, ' trabaja para ', manager.ename)
FROM emp empleado
JOIN emp manager
ON (empleado.mgr = manager.empno);

-- INCLUYENDO A KING QUE NO TIENE MANAGER

SELECT concat(empleado.ename, ' trabaja para ', NVL(manager.ename, 'sí mismo')) as jerarquia
FROM emp empleado
LEFT OUTER JOIN emp manager
ON (empleado.mgr = manager.empno);

-- OPERADORES SET (CONJUNTOS)

-- UNION (SUPRIME DUPLICADOS)
-- RECUPÈRAR TODOS LOS DETALLES ACTUALES Y ANTERIORES DE CADA EMPLEADO
SELECT empno, job, sal, comm, deptno, hiredate, 'actual'
FROM emp
UNION
SELECT empno, job, sal, comm, deptno, enddate, 'historico'
FROM jobhist
ORDER BY empno, hiredate;


-- UNION ALL (NO SUPRIME DUPLICADOS)

-- ¿HAY EMPLEADOS QUE VOLIERON A UN CARGO ANTERIOR?
SELECT empno, job, sal, hiredate as fecha
FROM emp
UNION ALL
SELECT empno, job, sal, enddate
FROM jobhist
ORDER BY empno;

-- INTERSECT

-- mostrar aquellos empleados que tengan el mismo oficio que ya tuvieron
SELECT empno, job
FROM emp
INTERSECT
SELECT empno, job
FROM jobhist
ORDER BY empno;

-- MINUS

-- empleados que nunca han cambiado de puesto
-- no soportado por MariaDB, se puede usar EXCEPT

SELECT empno, job
FROM emp
EXCEPT 
SELECT empno, job
FROM jobhist
ORDER BY empno;

