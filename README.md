# 🏀 Nas Quadras API 

Este projeto tem como ideia central servir como servidor backend para um site de catálogo de basquete. Sua função principal é cuidar das etapas de login e registro, entregar via requisições Http os dados de jogadores e franquias da NBA, bem como manter registros dos elencos que o usuário venha a montar, e seus jogadores favoritos.

## 🛠 Tecnologias Utilizadas

- [Spring]
- [JWT]

## 🎯 Objetivo

Demonstrar como construir um servidor Spring funcional e seguro que entregue dados dinamicamente a aplicação frontend de mesmo nome.

## 📄 Descrição do Projeto

O sistema é composto por pastas com responsabilidades específicas:

- Users
- Teams
- Rosters
- Players
- Config
- Security

## ⚙️ Trunfo do Projeto

- Foi realizado um mapeamento extenso de todos os jogadores da liga americana de basquete, pegando registros como nome completo, franquia a qual eles fazem parte, e a foto oficial da temporada 2024/2025. Esses dados foram catalogados e aplicados em um banco de dados próprio pela dificuldade de se encontrar uma api gratuita e bem organizada que oferecesse o mesmo serviço.

## 🗃️ JSON

- O arquivo JSON que foi criado para popular o banco de dados está disponível na aplicação para usos de estudo.

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/gabrielkazak/NasQuadras---Spring
   cd backend
   npm install
   crie um .env na raiz do projeto e adicione as URL alvo
   npm run start

## 💻 Repositório do Frontend

https://github.com/gabrielkazak/NasQuadras

## 👤 Autor

    Gabriel – Estudante de Informática
    Projeto desenvolvido como prática de utilização de Spring na criação de API's mais robustas
