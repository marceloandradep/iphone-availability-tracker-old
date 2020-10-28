# Getting Started

### Running the application

`./mvnw spring-boot:run`

### Configuration

Put the models you interested in tracking in `src/main/resources/phone-list.json` file. It already has all iPhone12 Pro and Pro Max models.

Change `availability-tracker.zipcode` to match your area.

To configure notifications:
* Change `availability-tracker.notification.enabled` to `true`.
* Put your gmail account in `spring.mail.username`.
* Create an app password in your google account configuration and put it in `spring.mail.password`.
* Add the e-mail you want to send notifications to in `email-notification.to`.

### Using the endpoint

```
curl --request GET \
  --url http://localhost:8080/availability
```