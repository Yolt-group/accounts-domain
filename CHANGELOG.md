# Changelog
## 7.0.9
 - Extracted accounts-domain from accounts-domain

## 7.0.7
- Inlined site-management-client in dependendants
- Inlined maintenance-client in dependendants

## 4.0.17
### Added
- Added `IN_CLOSING` to `KycStatusCode` enum
## 4.0.16
### Added
- Added `appVersion`: `phoneModel` fields to LastLoginUserDTO
## 4.0.15
### Added
- Fixed `AccountsClient`: `getUserAccounts` with `UserContext` as parameter, added **"user-id"** header also
## 4.0.14
### Added
- `AccountsClient`: `getUserAccounts` with `UserContext` as parameter (bug - do not use!!)
- Upgraded to LBC `5.1.7` to fix owasp finding
## 4.0.13
### Added
- `AccountsClient`: `getUserAccounts` accepts including parameter

## 4.0.12
### Added
- `UserDTO`: isEmailAddressVerified and isPhoneNumberClaimed property

## 4.0.10
### Added
- `UserDTO`: isBankingEnrollmentCompleted property

## 4.0.7
### Added
- `TransactionsByAccountDTO`

## 4.0.6
### Added
- `AccountsClient`: `getUserAccountsBySiteId` method

## 4.0.4
### Added
- `UserDTO`: isYolt2User property

## 4.0.3
### Added
- Upgrade LBC version to have the change for`UserContext - isYolt2User` property

## 4.0.2
### Added
- `UserDTO`: hasVerifiedEmail property

## 3.3.0
### Added
- `KycStatusCode`: INTERNAL_REVIEW enum.
### Changed
- lovebird-commons 3.3

## 3.2.8
### Added
- `UserDTO`: PaydayCycleConfig property

## 3.2.0
### Changed
- `UserDTO`: `type` property of payday cycle is `String`
### Removed
- deprecated argument in the constructor of UserContextClient
- deprecated methods in transactions-client

## 3.1.0
### Changed
- lovebird-commons 3.1
### Removed
- counterparties-client
- spending-client

## 3.0.0
### Changed
- lovebird-commons 3.0 with Spring Boot 2.1

## 2.8.1
### Added
- AccountDTO has an extra field: custom account number.

## 2.8.0
### Removed
- datascience-client
- recategorization-client

### Added
- FeatureConfigDTO has extra fields for testing groups.

## 2.7.0
### Changed
- UserDTO has 2 extra field: KycStatus and testUser. These break the allArgsConstructor.

## 2.6.9
### Changed
- UsersClient no longer supports deprecated feature-per-country. Use feature-per-client-country instead.

## 2.6.0
### Changed
- Service clients now use the `ObjectMapper` bean available in the Spring context, for consistent (de)serialization.

## 2.2.0
### Changed
- split the usersClient into a two: one fro creating users and one for transformations and getters. Only the proxies should use the createUsersClient

## 2.0.0
### Changed
- Spring Boot 2 & Spring Cloud Finchley

## 1.9.0
### Changed
- switch to Maven for builds; minimize transitive dependencies

## 1.6.0
### Added
- language to UserDTO constructor, and locale to UserDTO to get

## 1.3.0
### Added
- enum value to MigrationStatus in SiteManagementClient

## 1.2.1
### Removed
- fields from the BackEndUpdateAccountDTO

## 1.1.0
### Added
- the UserSiteDTO to the accountClient MigrationDTO. It breaks the old constructor

## 1.0.1
### Changed
- split the clients from lovebird-commons library