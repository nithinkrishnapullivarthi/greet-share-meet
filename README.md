# greet-share-meet
This web application helps students to greet,meet and share common interests

# Requirements
1. Install node
2. Install angular-cli using command `npm install -g @angular/cli`
3. Install `Visual Studio Code`. For developing angular code, it is suggested to be the best editor.

# How to start the angular app

1. Clone the repo
2. Open Terminal
3. cd greet-share-meet/frontend
4. `npm install` - This command installs all dependent node modules required to run the angular app
5. `ng serve` - This command launches the angular app on Port 4200
6. Visit `http://localhost:4200/`. You should see, `frontend app is running!` in UI.

# How to setup backend springboot app

1. Install MySQL database
2. Pull the latest changes in the repo using `git pull`
3. Navigate to backend folder in the repository and excute the command `mvn spring-boot:run`
4. Hit `http://localhost:8080/api/interests` in the browser.
5. You should be able to see interests API response.
