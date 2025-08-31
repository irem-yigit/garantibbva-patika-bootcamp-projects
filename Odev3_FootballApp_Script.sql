/* ---- Futbol İstatistik Uygulaması ----
 * Country: id, name
 * Lig: id, adı, id_country(hangi ülkenin ligi)
 * Takim: id, adı, id_leauge, kuruluş yılı, attığı gol, yediği gol, puan, seviye(1=en üst lig, 2, onun bir
 * alt ligi gibi)
 * Oyuncu: id, adı, soyadı, id_team, id_country(nereli), attığı gol*/
-- 1. Yukarıdaki tabloların create scriptlerini oluşturunuz.

create table country (
 	id SERIAL PRIMARY KEY,
 	name varchar(250)
 );
 

create table league (
	id SERIAL PRIMARY KEY,
	name varchar(250),
	id_country int,
	CONSTRAINT fk_country
      	FOREIGN KEY(id_country) 
	  	REFERENCES country(id)
	  	)

	  	
create table team(
	id SERIAL PRIMARY KEY,
	name varchar(250),
	id_league int,
	CONSTRAINT fk_league
      	FOREIGN KEY(id_league) 
	  	REFERENCES league(id),
	year int,
	scored_goal int,
	conceded_goal int,
	point int,
	level int
	)

	
create table player(
	id SERIAL PRIMARY KEY,
	name varchar(250),
    surname varchar(250),
	id_team int,
	CONSTRAINT fk_team
      	FOREIGN KEY(id_team) 
	  	REFERENCES team(id),
	id_country int,	  
	CONSTRAINT fk_country
      	FOREIGN KEY(id_country) 
	  	REFERENCES country(id),
	scored_goal int
	)

	
-- insert scripts	

insert into country (name) values('England');
insert into country (name) values ('Turkey');

insert into league (name, id_country) values('Premier League',1);
insert into league (name, id_country) values('Super League',2);

insert into team (name, id_league, year, scored_goal, conceded_goal, point, level) values ('Chelsea', 1, 1950, 50, 40, 25, 1);
insert into team (name, id_league, year, scored_goal, conceded_goal, point, level) values ('Arsenal', 1, 1980, 55, 65, 30, 1);
insert into player (name, surname, id_team, id_country, scored_goal) values ('John','Doe', 1, 1, 70);
insert into player (name, surname, id_team, id_country, scored_goal) values ('Mike', 'Poe', 2, 2, 50);

insert into team (name, id_league, year, scored_goal, conceded_goal, point, level) values ('Fenerbahce', 2, 1950, 50, 40, 25, 1);
insert into team (name, id_league, year, scored_goal, conceded_goal, point, level) values ('Galatasaray', 2, 1980, 55, 65, 30, 1);
insert into player (name, surname, id_team, id_country, scored_goal) values ('Mehmet','Topal', 3, 2, 70);
insert into player (name, surname, id_team, id_country, scored_goal) values ('Sergen', 'Yalcin', 4, 2, 50);


-- 2. Bu tabloları dolduran insert scriptler yazınız. Ligi olmayan takım
select * from country where name='Turkey'


-- 3. İsmi “Türkiye” olan ülkenin liglerinin listesini getiren scripti yazınız.
select * from league where id_country = (select id from country where name='Turkey')


-- 4. İsmi “Türkiye” olan ülkenin takımların listesini getiren scripti yazınız.
select * from team where id_league = (select id from league where id_country = (select id from country where name='Turkey') )


-- 5. İsmi “Türkiye” olan en üst seviyeli ligdeki puan tablosunu getiren scripti yazınız.
select name, point from team where level = (select min(level) from team) and id_league = (select id from league where id_country = (select id from country where name='Turkey') )


-- 6. Türkiye liglerindeki puan ortalamalarını gösteren scrpiti yazınız.
select id_league, avg(point) as average_point from team where id_league in (select id from league where id_country = (select id from country where name = 'Turkey')) group by id_league;


-- 7. Bir ligin Gol kralını getiren scprit yazınız. (oyuncu adı, soyadı, takım adı, nereli olduğu)
select player."name" from player 
	join team t on player.id_team = t.id 
	join country c on player.id_country = c.id 
where t.id_league = 1
order by player.scored_goal desc limit 1


-- 8. Tüm liglerde attığı gol yediği golden daha küçük olan takımları getiren scripti yazınız.
select team."name" , team.scored_goal , team.conceded_goal from team 
	join league on team.id_league = 1
where team.scored_goal < team.conceded_goal 
	

-- 9. Bir takımın oyuncularının toplam gol sayısını ve takımın gol sayısını yan yana getiren bir scprit yazınız. (kontrol sorgusu gibi, birisi takım verisi, diğeri oyuncuların toplamı olacak)
select team."name" , sum(player.scored_goal) as player_scored_goal , team.scored_goal as team_scored_g from team 
	join player on team.id = player.id_team 
	group by team.id 
