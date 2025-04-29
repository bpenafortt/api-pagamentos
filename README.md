# Desafio Técnico - Nível 1 | API de Pagamentos

## 📋 Descrição

API desenvolvida para recebimento de pagamentos de débitos de pessoas físicas e jurídicas.  
Permite:

- Cadastro de pagamentos.
- Atualização de status de pagamentos.
- Listagem e filtragem de pagamentos.
- Exclusão lógica de pagamentos.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Banco de Dados H2 (em memória)
- Maven

---

## 📚 Endpoints da API

### Criar um pagamento
```http
POST /api/v1/pagamentos
```
**Exemplo de body:**
```json
{
  "codigoDebito": 1234,
  "cpfCnpj": "12345678900",
  "metodoPagamento": "PIX",
  "valor": 250.00
}
```

---

### Atualizar status de pagamento
```http
PUT /api/v1/pagamentos/{id}/status
```
**Exemplo de body:**
```json
{
  "novoStatus": "PROCESSADO_SUCESSO"
}
```

### Listar pagamentos
```http
GET /api/v1/pagamentos
```
**Filtros opcionais:**
- `codigoDebito`
- `cpfCnpjPagador`
- `statusPagamento`

Exemplos:
```http
GET /api/v1/pagamentos?codigoDebito=1234
GET /api/v1/pagamentos?cpfCnpjPagador=12345678900
GET /api/v1/pagamentos?statusPagamento=PENDENTE_PROCESSAMENTO
```

---

### Exclusão lógica de pagamento
```http
DELETE /api/v1/pagamentos/{id}
```
---
