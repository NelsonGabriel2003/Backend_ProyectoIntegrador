INSERT IGNORE INTO roles (nombre) VALUES ('USUARIO');
INSERT IGNORE INTO roles (nombre) VALUES ('ADMIN');

INSERT IGNORE INTO categorias_reporte (nombre, descripcion, es_predefinida) VALUES ('BACHES', 'Huecos o daños en la vía pública', true);
INSERT IGNORE INTO categorias_reporte (nombre, descripcion, es_predefinida) VALUES ('BASURA', 'Acumulación de basura o falta de recolección', true);
INSERT IGNORE INTO categorias_reporte (nombre, descripcion, es_predefinida) VALUES ('ALUMBRADO_PUBLICO', 'Postes de luz dañados o sin funcionamiento', true);
INSERT IGNORE INTO categorias_reporte (nombre, descripcion, es_predefinida) VALUES ('ACERAS', 'Daños en aceras o veredas peatonales', true);
INSERT IGNORE INTO categorias_reporte (nombre, descripcion, es_predefinida) VALUES ('AGUA_ALCANTARILLADO', 'Problemas con agua potable o alcantarillado', true);
INSERT IGNORE INTO categorias_reporte (nombre, descripcion, es_predefinida) VALUES ('SEGURIDAD', 'Situaciones de inseguridad en la zona', true);
INSERT IGNORE INTO categorias_reporte (nombre, descripcion, es_predefinida) VALUES ('ALERTA_AMBER', 'Alerta de persona desaparecida reportada por ciudadano', false);
INSERT IGNORE INTO categorias_reporte (nombre, descripcion, es_predefinida) VALUES ('OTRO', 'Otro tipo de reporte creado por el ciudadano', false);
