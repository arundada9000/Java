# Security Policy

## Supported versions

This repository is a learning collection of standalone programs. There are no
"releases" or long-lived versions, so security fixes are applied to the latest
state of the `main` branch.

| State | Supported |
| --- | --- |
| `main` branch | yes |

## Reporting a vulnerability

If you find a security issue (for example, code that could leak credentials,
execute untrusted input, or expose the local machine), please do **not** open a
public issue with the details.

Instead, create a private report:

- Use **GitHub Security Advisories**: open the repository
  (`https://github.com/arundada9000/Java`) and click
  `Security` > `Report a vulnerability`, or
- Open a private issue if Security Advisories are unavailable.

Please include:

- A short description of the issue
- The affected file(s)
- A minimal reproduction, if possible

We will acknowledge reports and aim to address them promptly.

## Notes

- Some examples (e.g. `Servers and sockets/Java Mail`) contain placeholder
  credentials. Never commit real email addresses, passwords, API keys or tokens.
- JDBC examples connect to a local database; keep them pointed at localhost.