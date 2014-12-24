var FilmDistribution =  function filmDistribution(
    name,
    nativeName,
    year,
    description,
    ganre,
    country,
    links,
    time,
    linkKinopoisk,
    linkImdb
    ){
    this.name = name;
    this.nativeName = nativeName;
    this.year = year;
    this.description = description;
    this.ganre = ganre;
    this.country = country;
    this.links = links;
    this.time = time;
    this.linkKinopoisk = linkKinopoisk;
    this.linkImdb = linkImdb;
};

var AudioDistribution = function audioDistribution(
    name,
    nativeName,
    year,
    description,
    ganre,
    country,
    links,
    time
){
    this.name = name;
    this.nativeName = nativeName;
    this.year = year;
    this.description = description;
    this.ganre = ganre;
    this.country = country;
    this.links = links;
    this.time = time;
};

var BookDistribution = function bookDistribution(
    name,
    nativeName,
    year,
    description,
    ganre,
    country,
    links,
    author
){
    this.name = name;
    this.nativeName = nativeName;
    this.year = year;
    this.description = description;
    this.ganre = ganre;
    this.country = country;
    this.links = links;
    this.author = author;
};

var GameDistribution = function gameDistribution(
    name,
    nativeName,
    year,
    description,
    ganre,
    country,
    links,
    publisher,
    developer,
    publicationType,
    language,
    translate
){
    this.name = name;
    this.nativeName = nativeName;
    this.year = year;
    this.description = description;
    this.ganre = ganre;
    this.country = country;
    this.links = links;
    this.publisher = publisher;
    this.developer = developer;
    this.publicationType = publicationType;
    this.language = language;
    this.translate = translate;
};

var UserProfile = function userProfile(
    login,
    email,
    role
){
    this.login = login;
    this.email = email;
    this.role = role;
};