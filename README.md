
# Registro de universidad sencillo - Tarea de POO

Registrar alumnos/docentes, modificarlos y eliminarlos usando java swing para ser guardados en un archivos .json o una base de datos sql,
luego leer el archivo .json o hacer una consulta sql para poder visualizarlos en una tabla de swing, además de generar un reporte en pdf de los alumnos y docentes.

## Descargas

[![Static Badge](https://img.shields.io/badge/java_.jar-1.4.0-green)](https://github.com/PaoloESAN/tareaPOO/releases/download/v1.4.0/TareaDePOO.jar)

## Librerías
- [Flatlaf](https://github.com/JFormDesigner/FlatLaf)
- [JSON-java](https://github.com/stleary/JSON-java)
- [SQL Server](https://learn.microsoft.com/es-es/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver16)
- [itextpdf](https://github.com/itext/itextpdf)
## Creditos
- Codigo para generar el pdf de: [PatrickNv23](https://github.com/PatrickNv23)
https://github.com/PatrickNv23/ReportePDF_Java/blob/main/src/main/java/dominio/ReporteEmpleados.java

## Solución de problemas SQL

> [!NOTE]
> El programa usa SQL server

Primero comprueba que el servicio sql server browser se está ejecutando.

Si aún no funciona, realiza los siguientes pasos:
1) ir a SQL server configuration manager
2) en configuración de red de sql server, al lado seleccionar: protocolos de SQL
3) doble clik a TCP/IP
4) en protocolo, darle a: habilitado: Si
5) en direcciones IP, bajar hasta el final a IPAII, si no hay nada en el puerto TCP, poner: 1433 y aceptar

## Screenshots

Modo Oscuro:

![image](https://github.com/user-attachments/assets/00792840-f43d-4e2d-a7b7-bd55f3cd6cd5)

![image](https://github.com/user-attachments/assets/0f92c646-9b16-4a90-84c0-f3d3824a3072)

![image](https://github.com/user-attachments/assets/b9038db3-eff5-46d7-b4de-2c41fb7c67b1)

![image](https://github.com/user-attachments/assets/3402663d-b5bd-47d4-8643-38f5f1e650c5)

![image](https://github.com/user-attachments/assets/ea459dd0-64ed-4057-a4d1-c6dd33865de1)

![image](https://github.com/user-attachments/assets/b914c3b0-b2db-4a8b-9ced-80934fccad12)

Modo claro:

![image](https://github.com/user-attachments/assets/43e9ae89-a7bb-448e-9383-87703b9827fd)

![image](https://github.com/user-attachments/assets/dbb883c4-6b2b-49f1-9477-3b4c3dabfe2f)

![image](https://github.com/user-attachments/assets/85bf74f5-8ca3-4468-a6b1-f4b1ab011b80)

![image](https://github.com/user-attachments/assets/2b7db7a9-af9d-4ef9-a476-28e9bfe89f2b)

![image](https://github.com/user-attachments/assets/4bac49c5-d52f-42c4-b539-0e3a51f53bd0)
