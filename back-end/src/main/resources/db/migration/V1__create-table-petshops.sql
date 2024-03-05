CREATE TABLE petshops (
    id bigint not null,
    nome TEXT not null,
    distancia int not null,
    precoPequeno float not null,
    precoGrande float not null,
    precoPequenoFDS float null default 0.0,
    precoGrandeFDS float null default 0.0
);