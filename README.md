# UUN-Java-Semester-Work

## Dokumentace

Aplikace umožňuje pomocí REST volání vyhledat základní informace o ekonomickém
subjektu z ARES API. Dále umožňuje vyhledávání, ukládání, upravování a mazání
subjektů uložených v lokální postgres databázi.

### Setup

Je vyžadován PostgreSQL dostupný na portu 5432.

### Funkce

#### POST /api/ares/subject/{ico}

Vyhledá ekonomický subjekt podle IČO.

#### GET /api/subjects/{id}

Vyhledá ekonomický subjekt pomocí interního `id`.

#### POST /api/subjects/add?ico={ico}&acronym={acronym}&description={description}

Uloží ekonomický subjekt se zadanými parametry do databáze.

#### PUT /api/subjects/update/{id}?acronym={acronym}&description={description}

Upraví parametry `acronym` nebo `description` v záznamu podle `id`.

#### DELETE /api/subjects/delete/{id}

Odstraní záznam ekonomického subjektu podle `id`.

## Autoři

- Dai Gia Vu [@ShadowHunter96](https://github.com/ShadowHunter96)
- Ota Vlna [@otavlna](https://github.com/otavlna)
- David Ryšánek [@RysanekDavid](https://github.com/RysanekDavid)
- Roman Bohoš
