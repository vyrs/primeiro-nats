CREATE KEYSPACE produto WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1};

--CREATE KEYSPACE Produto
--WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};
--AND durable_writes = true;

use produto;

CREATE TABLE produto(
    id uuid,
    nome text,
    categoria text,
    preco decimal,
    PRIMARY KEY (id)
);
