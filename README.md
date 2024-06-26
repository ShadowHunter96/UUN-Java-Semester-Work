# UUN-Java-Semester-Work

## Dokumentace

Aplikace **"SubManager"** umožňuje pomocí REST volání vyhledat základní informace o ekonomickém subjektu z ARES API. Dále umožňuje vyhledávání, ukládání, upravování a mazání subjektů uložených v lokální postgres databázi.

## Setup

Je vyžadován PostgreSQL dostupný na portu 5432.

## Funkce

### Vyhledávání subjektů pomocí ARES

- **Endpoint**: `POST /api/ares/subject/{ico}`
- **Popis**: Vyhledá ekonomický subjekt podle IČO.

### Získání subjektu podle ID

- **Endpoint**: `GET /api/subjects/{id}`
- **Popis**: Vyhledá ekonomický subjekt pomocí interního ID.

### Přidání nového subjektu

- **Endpoint**: `POST /api/subjects/add?ico={ico}&acronym={acronym}&description={description}`
- **Popis**: Uloží ekonomický subjekt se zadanými parametry do databáze.

### Aktualizace existujícího subjektu

- **Endpoint**: `PUT /api/subjects/update/{id}?acronym={acronym}&description={description}`
- **Popis**: Upraví parametry acronym nebo description v záznamu podle ID.

### Smazání subjektu

- **Endpoint**: `DELETE /api/subjects/delete/{id}`
- **Popis**: Odstraní záznam ekonomického subjektu podle ID.

## Technologie

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**

## Použití

Aplikace může být použita jako backend služba pro správu ekonomických subjektů v rámci informačního systému. Poskytuje rozhraní pro integraci s jinými aplikacemi nebo frontend rozhraním.

### Příklady použití

- Informační systém pro školy, kde je potřeba evidovat a spravovat informace o ekonomických subjektech (dodavatelé, partneři apod.).
- Databáze firem a organizací pro účely analýzy a reportingu.
- Integrace s externími systémy, které vyžadují informace o ekonomických subjektech.

## Závěr

Aplikace **"SubManager"** usnadňuje správu ekonomických subjektů pomocí REST API rozhraní. Umožňuje vyhledávání subjektů pomocí služby ARES, přidávání nových subjektů, aktualizaci a mazání existujících subjektů.

---

## Autoři

- Dai Gia Vu [@ShadowHunter96](https://github.com/ShadowHunter96)
- Ota Vlna [@otavlna](https://github.com/otavlna)
- David Ryšánek [@RysanekDavid](https://github.com/RysanekDavid)
- Roman Bohoš
