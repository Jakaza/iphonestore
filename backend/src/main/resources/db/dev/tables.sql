CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  email VARCHAR(255) CHECK (provider <> 'email' OR email IS NOT NULL),
  phone_number VARCHAR(20),
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  password VARCHAR(255),
  merchant_id INTEGER REFERENCES merchants(id) DEFAULT NULL,
  provider VARCHAR(50) NOT NULL DEFAULT 'email',
  google_id VARCHAR(50),
  facebook_id VARCHAR(50),
  avatar TEXT,
  role VARCHAR(50) NOT NULL DEFAULT 'Member',
  reset_password_token VARCHAR(255),
  reset_password_expires TIMESTAMP,
  updated TIMESTAMP,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CHECK (role IN ('Admin', 'Member', 'Merchant'))
);
CREATE TABLE merchants (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) TRIM,
  email VARCHAR(255),
  phone_number VARCHAR(20),
  brand_name VARCHAR(255),
  business VARCHAR(255) TRIM,
  is_active BOOLEAN DEFAULT FALSE,
  brand_id INTEGER REFERENCES brands(id) DEFAULT NULL,
  status VARCHAR(50) DEFAULT 'Waiting_Approval',
  updated TIMESTAMP,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CHECK (status IN ('Waiting_Approval', 'Rejected', 'Approved'))
);
CREATE TABLE brands (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) TRIM,
  slug VARCHAR(255) UNIQUE,
  image_path TEXT,
  description TEXT TRIM,
  is_active BOOLEAN DEFAULT TRUE,
  merchant_id INTEGER REFERENCES merchants(id) DEFAULT NULL,
  updated TIMESTAMP,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

