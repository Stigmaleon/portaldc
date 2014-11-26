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
