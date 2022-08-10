--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5 (Ubuntu 11.5-3.pgdg18.04+1)
-- Dumped by pg_dump version 12.5

-- Started on 2022-05-19 20:16:10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 24 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 4253 (class 0 OID 0)
-- Dependencies: 24
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

--
-- TOC entry 223 (class 1259 OID 11571704)
-- Name: boards_preset; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.boards_preset (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    board_type character varying(255),
    board_view character varying(255),
    name character varying(255),
    text character varying(255),
    user_id bigint
);


ALTER TABLE public.boards_preset OWNER TO jxwzhxhe;

--
-- TOC entry 224 (class 1259 OID 11571712)
-- Name: categories; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.categories (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    name character varying(255),
    user_id bigint,
    category_id bigint
);


ALTER TABLE public.categories OWNER TO jxwzhxhe;

--
-- TOC entry 225 (class 1259 OID 11571717)
-- Name: contractor_address; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.contractor_address (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    address character varying(255),
    contact_persone character varying(255),
    description character varying(255),
    fias character varying(255),
    phone character varying(255),
    user_id bigint
);


ALTER TABLE public.contractor_address OWNER TO jxwzhxhe;

--
-- TOC entry 226 (class 1259 OID 11571725)
-- Name: contractors; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.contractors (
    contractor character varying(31) NOT NULL,
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    type character varying(255),
    inn integer,
    kpp integer,
    name character varying(255),
    ogrn integer,
    short_name character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    middle_name character varying(255),
    user_id bigint
);


ALTER TABLE public.contractors OWNER TO jxwzhxhe;

--
-- TOC entry 227 (class 1259 OID 11571733)
-- Name: contractors_contractor_address; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.contractors_contractor_address (
    contractors_id bigint NOT NULL,
    contractor_address_id bigint NOT NULL
);


ALTER TABLE public.contractors_contractor_address OWNER TO jxwzhxhe;

--
-- TOC entry 228 (class 1259 OID 11571736)
-- Name: contractors_email; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.contractors_email (
    contractors_id bigint NOT NULL,
    email_id bigint NOT NULL
);


ALTER TABLE public.contractors_email OWNER TO jxwzhxhe;

--
-- TOC entry 229 (class 1259 OID 11571739)
-- Name: contractors_passport; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.contractors_passport (
    person_id bigint NOT NULL,
    passport_id bigint NOT NULL
);


ALTER TABLE public.contractors_passport OWNER TO jxwzhxhe;

--
-- TOC entry 230 (class 1259 OID 11571742)
-- Name: contractors_phones; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.contractors_phones (
    contractors_id bigint NOT NULL,
    phones_id bigint NOT NULL
);


ALTER TABLE public.contractors_phones OWNER TO jxwzhxhe;

--
-- TOC entry 231 (class 1259 OID 11571745)
-- Name: emails; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.emails (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    active boolean NOT NULL,
    text character varying(255),
    user_id bigint
);


ALTER TABLE public.emails OWNER TO jxwzhxhe;

--
-- TOC entry 222 (class 1259 OID 11333264)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: jxwzhxhe
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO jxwzhxhe;

--
-- TOC entry 232 (class 1259 OID 11571750)
-- Name: notifications; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.notifications (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    text character varying(255),
    title character varying(255),
    user_id bigint,
    contractor_id bigint
);


ALTER TABLE public.notifications OWNER TO jxwzhxhe;

--
-- TOC entry 233 (class 1259 OID 11571758)
-- Name: order_items; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.order_items (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    price double precision,
    qty double precision,
    user_id bigint,
    order_id bigint,
    product_id bigint
);


ALTER TABLE public.order_items OWNER TO jxwzhxhe;

--
-- TOC entry 234 (class 1259 OID 11571763)
-- Name: orders; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.orders (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    name character varying(255),
    order_status character varying(255),
    user_id bigint,
    contractor_id bigint,
    contractor_address_id bigint,
    request_id bigint
);


ALTER TABLE public.orders OWNER TO jxwzhxhe;

--
-- TOC entry 235 (class 1259 OID 11571771)
-- Name: passport; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.passport (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    active boolean NOT NULL,
    issue_date date,
    issuer character varying(255),
    number character varying(255),
    serial character varying(255),
    type character varying(255),
    user_id bigint
);


ALTER TABLE public.passport OWNER TO jxwzhxhe;

--
-- TOC entry 236 (class 1259 OID 11571779)
-- Name: phones; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.phones (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    active boolean NOT NULL,
    code character varying(255),
    text character varying(255),
    user_id bigint
);


ALTER TABLE public.phones OWNER TO jxwzhxhe;

--
-- TOC entry 237 (class 1259 OID 11571787)
-- Name: products; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.products (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    cost double precision,
    description character varying(255),
    name character varying(255),
    title character varying(255),
    user_id bigint,
    category_id bigint
);


ALTER TABLE public.products OWNER TO jxwzhxhe;

--
-- TOC entry 238 (class 1259 OID 11571795)
-- Name: request_status_log; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.request_status_log (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    comment character varying(255),
    local_date date,
    resolution character varying(255),
    user_id bigint,
    request_id bigint,
    request_status_id bigint
);


ALTER TABLE public.request_status_log OWNER TO jxwzhxhe;

--
-- TOC entry 239 (class 1259 OID 11571803)
-- Name: request_statuses; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.request_statuses (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    name character varying(255),
    request_status_type character varying(255),
    user_id bigint
);


ALTER TABLE public.request_statuses OWNER TO jxwzhxhe;

--
-- TOC entry 240 (class 1259 OID 11571811)
-- Name: request_type; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.request_type (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    archive boolean NOT NULL,
    name character varying(255),
    user_id bigint,
    request_type_id bigint,
    work_flow_id bigint
);


ALTER TABLE public.request_type OWNER TO jxwzhxhe;

--
-- TOC entry 241 (class 1259 OID 11571816)
-- Name: requests; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.requests (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    number character varying(255),
    resolution character varying(255),
    user_id bigint,
    contractor_id bigint,
    contractor_address_id bigint,
    request_status_id bigint,
    request_type_id bigint
);


ALTER TABLE public.requests OWNER TO jxwzhxhe;

--
-- TOC entry 242 (class 1259 OID 11571824)
-- Name: roles; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.roles (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    active boolean NOT NULL,
    code character varying(255),
    name character varying(255),
    user_id bigint
);


ALTER TABLE public.roles OWNER TO jxwzhxhe;

--
-- TOC entry 243 (class 1259 OID 11571832)
-- Name: tasks; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.tasks (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    close timestamp without time zone,
    status character varying(255),
    text character varying(255),
    title character varying(255),
    user_id bigint,
    request_id bigint
);


ALTER TABLE public.tasks OWNER TO jxwzhxhe;

--
-- TOC entry 244 (class 1259 OID 11571840)
-- Name: tasks_messages; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.tasks_messages (
    task_id bigint NOT NULL,
    messages_id bigint NOT NULL
);


ALTER TABLE public.tasks_messages OWNER TO jxwzhxhe;

--
-- TOC entry 245 (class 1259 OID 11571843)
-- Name: users; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    activation_code character varying(255),
    active boolean NOT NULL,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    middle_name character varying(255),
    password character varying(255),
    user_name character varying(255),
    user_id bigint
);


ALTER TABLE public.users OWNER TO jxwzhxhe;

--
-- TOC entry 246 (class 1259 OID 11571851)
-- Name: users_roles; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.users_roles (
    user_id bigint NOT NULL,
    roles_id bigint NOT NULL
);


ALTER TABLE public.users_roles OWNER TO jxwzhxhe;

--
-- TOC entry 247 (class 1259 OID 11571856)
-- Name: work_flows; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.work_flows (
    id bigint NOT NULL,
    created timestamp without time zone,
    modified timestamp without time zone,
    version integer NOT NULL,
    code character varying(255),
    name character varying(255),
    user_id bigint
);


ALTER TABLE public.work_flows OWNER TO jxwzhxhe;

--
-- TOC entry 248 (class 1259 OID 11571864)
-- Name: work_flows_board_preset; Type: TABLE; Schema: public; Owner: jxwzhxhe
--

CREATE TABLE public.work_flows_board_preset (
    work_flow_id bigint NOT NULL,
    board_preset_id bigint NOT NULL
);


ALTER TABLE public.work_flows_board_preset OWNER TO jxwzhxhe;

--
-- TOC entry 4222 (class 0 OID 11571704)
-- Dependencies: 223
-- Data for Name: boards_preset; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.boards_preset (id, created, modified, version, board_type, board_view, name, text, user_id) FROM stdin;
\.


--
-- TOC entry 4223 (class 0 OID 11571712)
-- Dependencies: 224
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.categories (id, created, modified, version, name, user_id, category_id) FROM stdin;
\.


--
-- TOC entry 4224 (class 0 OID 11571717)
-- Dependencies: 225
-- Data for Name: contractor_address; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.contractor_address (id, created, modified, version, address, contact_persone, description, fias, phone, user_id) FROM stdin;
\.


--
-- TOC entry 4225 (class 0 OID 11571725)
-- Dependencies: 226
-- Data for Name: contractors; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.contractors (contractor, id, created, modified, version, type, inn, kpp, name, ogrn, short_name, first_name, last_name, middle_name, user_id) FROM stdin;
\.


--
-- TOC entry 4226 (class 0 OID 11571733)
-- Dependencies: 227
-- Data for Name: contractors_contractor_address; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.contractors_contractor_address (contractors_id, contractor_address_id) FROM stdin;
\.


--
-- TOC entry 4227 (class 0 OID 11571736)
-- Dependencies: 228
-- Data for Name: contractors_email; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.contractors_email (contractors_id, email_id) FROM stdin;
\.


--
-- TOC entry 4228 (class 0 OID 11571739)
-- Dependencies: 229
-- Data for Name: contractors_passport; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.contractors_passport (person_id, passport_id) FROM stdin;
\.


--
-- TOC entry 4229 (class 0 OID 11571742)
-- Dependencies: 230
-- Data for Name: contractors_phones; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.contractors_phones (contractors_id, phones_id) FROM stdin;
\.


--
-- TOC entry 4230 (class 0 OID 11571745)
-- Dependencies: 231
-- Data for Name: emails; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.emails (id, created, modified, version, active, text, user_id) FROM stdin;
\.


--
-- TOC entry 4231 (class 0 OID 11571750)
-- Dependencies: 232
-- Data for Name: notifications; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.notifications (id, created, modified, version, text, title, user_id, contractor_id) FROM stdin;
\.


--
-- TOC entry 4232 (class 0 OID 11571758)
-- Dependencies: 233
-- Data for Name: order_items; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.order_items (id, created, modified, version, price, qty, user_id, order_id, product_id) FROM stdin;
\.


--
-- TOC entry 4233 (class 0 OID 11571763)
-- Dependencies: 234
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.orders (id, created, modified, version, name, order_status, user_id, contractor_id, contractor_address_id, request_id) FROM stdin;
\.


--
-- TOC entry 4234 (class 0 OID 11571771)
-- Dependencies: 235
-- Data for Name: passport; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.passport (id, created, modified, version, active, issue_date, issuer, number, serial, type, user_id) FROM stdin;
\.


--
-- TOC entry 4235 (class 0 OID 11571779)
-- Dependencies: 236
-- Data for Name: phones; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.phones (id, created, modified, version, active, code, text, user_id) FROM stdin;
\.


--
-- TOC entry 4236 (class 0 OID 11571787)
-- Dependencies: 237
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.products (id, created, modified, version, cost, description, name, title, user_id, category_id) FROM stdin;
\.


--
-- TOC entry 4237 (class 0 OID 11571795)
-- Dependencies: 238
-- Data for Name: request_status_log; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.request_status_log (id, created, modified, version, comment, local_date, resolution, user_id, request_id, request_status_id) FROM stdin;
\.


--
-- TOC entry 4238 (class 0 OID 11571803)
-- Dependencies: 239
-- Data for Name: request_statuses; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.request_statuses (id, created, modified, version, name, request_status_type, user_id) FROM stdin;
\.


--
-- TOC entry 4239 (class 0 OID 11571811)
-- Dependencies: 240
-- Data for Name: request_type; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.request_type (id, created, modified, version, archive, name, user_id, request_type_id, work_flow_id) FROM stdin;
\.


--
-- TOC entry 4240 (class 0 OID 11571816)
-- Dependencies: 241
-- Data for Name: requests; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.requests (id, created, modified, version, number, resolution, user_id, contractor_id, contractor_address_id, request_status_id, request_type_id) FROM stdin;
\.


--
-- TOC entry 4241 (class 0 OID 11571824)
-- Dependencies: 242
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.roles (id, created, modified, version, active, code, name, user_id) FROM stdin;
\.


--
-- TOC entry 4242 (class 0 OID 11571832)
-- Dependencies: 243
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.tasks (id, created, modified, version, close, status, text, title, user_id, request_id) FROM stdin;
\.


--
-- TOC entry 4243 (class 0 OID 11571840)
-- Dependencies: 244
-- Data for Name: tasks_messages; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.tasks_messages (task_id, messages_id) FROM stdin;
\.


--
-- TOC entry 4244 (class 0 OID 11571843)
-- Dependencies: 245
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.users (id, created, modified, version, activation_code, active, email, first_name, last_name, middle_name, password, user_name, user_id) FROM stdin;
\.


--
-- TOC entry 4245 (class 0 OID 11571851)
-- Dependencies: 246
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.users_roles (user_id, roles_id) FROM stdin;
\.


--
-- TOC entry 4246 (class 0 OID 11571856)
-- Dependencies: 247
-- Data for Name: work_flows; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.work_flows (id, created, modified, version, code, name, user_id) FROM stdin;
\.


--
-- TOC entry 4247 (class 0 OID 11571864)
-- Dependencies: 248
-- Data for Name: work_flows_board_preset; Type: TABLE DATA; Schema: public; Owner: jxwzhxhe
--

COPY public.work_flows_board_preset (work_flow_id, board_preset_id) FROM stdin;
\.


--
-- TOC entry 4254 (class 0 OID 0)
-- Dependencies: 222
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: jxwzhxhe
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- TOC entry 3994 (class 2606 OID 11571711)
-- Name: boards_preset boards_preset_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.boards_preset
    ADD CONSTRAINT boards_preset_pkey PRIMARY KEY (id);


--
-- TOC entry 3996 (class 2606 OID 11571716)
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- TOC entry 3998 (class 2606 OID 11571724)
-- Name: contractor_address contractor_address_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractor_address
    ADD CONSTRAINT contractor_address_pkey PRIMARY KEY (id);


--
-- TOC entry 4000 (class 2606 OID 11571732)
-- Name: contractors contractors_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors
    ADD CONSTRAINT contractors_pkey PRIMARY KEY (id);


--
-- TOC entry 4010 (class 2606 OID 11571749)
-- Name: emails emails_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.emails
    ADD CONSTRAINT emails_pkey PRIMARY KEY (id);


--
-- TOC entry 4012 (class 2606 OID 11571757)
-- Name: notifications notifications_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT notifications_pkey PRIMARY KEY (id);


--
-- TOC entry 4014 (class 2606 OID 11571762)
-- Name: order_items order_items_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT order_items_pkey PRIMARY KEY (id);


--
-- TOC entry 4016 (class 2606 OID 11571770)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 4018 (class 2606 OID 11571778)
-- Name: passport passport_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.passport
    ADD CONSTRAINT passport_pkey PRIMARY KEY (id);


--
-- TOC entry 4020 (class 2606 OID 11571786)
-- Name: phones phones_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.phones
    ADD CONSTRAINT phones_pkey PRIMARY KEY (id);


--
-- TOC entry 4022 (class 2606 OID 11571794)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- TOC entry 4024 (class 2606 OID 11571802)
-- Name: request_status_log request_status_log_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.request_status_log
    ADD CONSTRAINT request_status_log_pkey PRIMARY KEY (id);


--
-- TOC entry 4026 (class 2606 OID 11571810)
-- Name: request_statuses request_statuses_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.request_statuses
    ADD CONSTRAINT request_statuses_pkey PRIMARY KEY (id);


--
-- TOC entry 4028 (class 2606 OID 11571815)
-- Name: request_type request_type_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.request_type
    ADD CONSTRAINT request_type_pkey PRIMARY KEY (id);


--
-- TOC entry 4030 (class 2606 OID 11571823)
-- Name: requests requests_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.requests
    ADD CONSTRAINT requests_pkey PRIMARY KEY (id);


--
-- TOC entry 4032 (class 2606 OID 11571831)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 4038 (class 2606 OID 11571839)
-- Name: tasks tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);


--
-- TOC entry 4006 (class 2606 OID 11571872)
-- Name: contractors_passport uk_1c93w4c3qwu9smn2y0weptket; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors_passport
    ADD CONSTRAINT uk_1c93w4c3qwu9smn2y0weptket UNIQUE (passport_id);


--
-- TOC entry 4008 (class 2606 OID 11571874)
-- Name: contractors_phones uk_3esrjihl2jmpqsu3gb0wp2utu; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors_phones
    ADD CONSTRAINT uk_3esrjihl2jmpqsu3gb0wp2utu UNIQUE (phones_id);


--
-- TOC entry 4044 (class 2606 OID 11571882)
-- Name: users_roles uk_60loxav507l5mreo05v0im1lq; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT uk_60loxav507l5mreo05v0im1lq UNIQUE (roles_id);


--
-- TOC entry 4034 (class 2606 OID 11571876)
-- Name: roles uk_ch1113horj4qr56f91omojv8; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT uk_ch1113horj4qr56f91omojv8 UNIQUE (code);


--
-- TOC entry 4004 (class 2606 OID 11571870)
-- Name: contractors_email uk_e6ks9cq6f75m9i7ug9wos5d93; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors_email
    ADD CONSTRAINT uk_e6ks9cq6f75m9i7ug9wos5d93 UNIQUE (email_id);


--
-- TOC entry 4002 (class 2606 OID 11571868)
-- Name: contractors_contractor_address uk_kwarh96e2qme8snmkl1onl63w; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors_contractor_address
    ADD CONSTRAINT uk_kwarh96e2qme8snmkl1onl63w UNIQUE (contractor_address_id);


--
-- TOC entry 4036 (class 2606 OID 11571878)
-- Name: roles uk_ofx66keruapi6vyqpv6f2or37; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT uk_ofx66keruapi6vyqpv6f2or37 UNIQUE (name);


--
-- TOC entry 4040 (class 2606 OID 11571880)
-- Name: tasks_messages uk_thyj5qpu8pv8rtnbnjll9mymi; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.tasks_messages
    ADD CONSTRAINT uk_thyj5qpu8pv8rtnbnjll9mymi UNIQUE (messages_id);


--
-- TOC entry 4042 (class 2606 OID 11571850)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 4046 (class 2606 OID 11571855)
-- Name: users_roles users_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT users_roles_pkey PRIMARY KEY (user_id, roles_id);


--
-- TOC entry 4048 (class 2606 OID 11571863)
-- Name: work_flows work_flows_pkey; Type: CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.work_flows
    ADD CONSTRAINT work_flows_pkey PRIMARY KEY (id);


--
-- TOC entry 4051 (class 2606 OID 11571893)
-- Name: categories fk1e7hbubpwyuq2199b8jrx42h8; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT fk1e7hbubpwyuq2199b8jrx42h8 FOREIGN KEY (category_id) REFERENCES public.categories(id);


--
-- TOC entry 4078 (class 2606 OID 11572028)
-- Name: request_status_log fk29worlvkqyey1rfpevwf77ekr; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.request_status_log
    ADD CONSTRAINT fk29worlvkqyey1rfpevwf77ekr FOREIGN KEY (request_status_id) REFERENCES public.request_statuses(id);


--
-- TOC entry 4095 (class 2606 OID 11572113)
-- Name: users_roles fk2o0jvgh89lemvvo17cbqvdxaa; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fk2o0jvgh89lemvvo17cbqvdxaa FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4068 (class 2606 OID 11571978)
-- Name: orders fk32ql8ubntj5uh44ph9659tiih; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk32ql8ubntj5uh44ph9659tiih FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4069 (class 2606 OID 11571983)
-- Name: orders fk3xvcmuk6a7ktrx3awo4ye55fs; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk3xvcmuk6a7ktrx3awo4ye55fs FOREIGN KEY (contractor_id) REFERENCES public.contractors(id);


--
-- TOC entry 4062 (class 2606 OID 11571948)
-- Name: emails fk41wb6kvdemvj1602iltrfr1uo; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.emails
    ADD CONSTRAINT fk41wb6kvdemvj1602iltrfr1uo FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4087 (class 2606 OID 11572073)
-- Name: requests fk5gg1w22sui9wrcdrdk1pfcmhl; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.requests
    ADD CONSTRAINT fk5gg1w22sui9wrcdrdk1pfcmhl FOREIGN KEY (request_type_id) REFERENCES public.request_type(id);


--
-- TOC entry 4089 (class 2606 OID 11572083)
-- Name: tasks fk6s1ob9k4ihi75xbxe2w0ylsdh; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT fk6s1ob9k4ihi75xbxe2w0ylsdh FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4061 (class 2606 OID 11571943)
-- Name: contractors_phones fk79cearxgvg4eehtcae08sewt0; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors_phones
    ADD CONSTRAINT fk79cearxgvg4eehtcae08sewt0 FOREIGN KEY (contractors_id) REFERENCES public.contractors(id);


--
-- TOC entry 4097 (class 2606 OID 11572123)
-- Name: work_flows_board_preset fk7w93vwiitxncg1d6vq0h2sq62; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.work_flows_board_preset
    ADD CONSTRAINT fk7w93vwiitxncg1d6vq0h2sq62 FOREIGN KEY (board_preset_id) REFERENCES public.boards_preset(id);


--
-- TOC entry 4098 (class 2606 OID 11572128)
-- Name: work_flows_board_preset fk7yua085m0u69yfu03x6makyi8; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.work_flows_board_preset
    ADD CONSTRAINT fk7yua085m0u69yfu03x6makyi8 FOREIGN KEY (work_flow_id) REFERENCES public.work_flows(id);


--
-- TOC entry 4082 (class 2606 OID 11572048)
-- Name: request_type fk87iuhlk7n1jjvely6htgl0gmc; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.request_type
    ADD CONSTRAINT fk87iuhlk7n1jjvely6htgl0gmc FOREIGN KEY (work_flow_id) REFERENCES public.work_flows(id);


--
-- TOC entry 4084 (class 2606 OID 11572058)
-- Name: requests fk89uiosdh3q69i7et4bmwnshd; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.requests
    ADD CONSTRAINT fk89uiosdh3q69i7et4bmwnshd FOREIGN KEY (contractor_id) REFERENCES public.contractors(id);


--
-- TOC entry 4055 (class 2606 OID 11571913)
-- Name: contractors_contractor_address fk8bb6qjtx6mlj0xcf6h6pbxoaa; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors_contractor_address
    ADD CONSTRAINT fk8bb6qjtx6mlj0xcf6h6pbxoaa FOREIGN KEY (contractors_id) REFERENCES public.contractors(id);


--
-- TOC entry 4083 (class 2606 OID 11572053)
-- Name: requests fk8usbpx9csc6opbjg1d7kvtf8c; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.requests
    ADD CONSTRAINT fk8usbpx9csc6opbjg1d7kvtf8c FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4088 (class 2606 OID 11572078)
-- Name: roles fk97mxvrajhkq19dmvboprimeg1; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT fk97mxvrajhkq19dmvboprimeg1 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4063 (class 2606 OID 11571953)
-- Name: notifications fk9y21adhxn0ayjhfocscqox7bh; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT fk9y21adhxn0ayjhfocscqox7bh FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4094 (class 2606 OID 11572108)
-- Name: users_roles fka62j07k5mhgifpp955h37ponj; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fka62j07k5mhgifpp955h37ponj FOREIGN KEY (roles_id) REFERENCES public.roles(id);


--
-- TOC entry 4066 (class 2606 OID 11571968)
-- Name: order_items fkbioxgbv59vetrxe0ejfubep1w; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT fkbioxgbv59vetrxe0ejfubep1w FOREIGN KEY (order_id) REFERENCES public.orders(id);


--
-- TOC entry 4074 (class 2606 OID 11572008)
-- Name: products fkdb050tk37qryv15hd932626th; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fkdb050tk37qryv15hd932626th FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4091 (class 2606 OID 11572093)
-- Name: tasks_messages fke41fncpec0d5bx3asu2rb12wv; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.tasks_messages
    ADD CONSTRAINT fke41fncpec0d5bx3asu2rb12wv FOREIGN KEY (messages_id) REFERENCES public.notifications(id);


--
-- TOC entry 4092 (class 2606 OID 11572098)
-- Name: tasks_messages fkeb8jq0vr9qo1km7du7ipe45vx; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.tasks_messages
    ADD CONSTRAINT fkeb8jq0vr9qo1km7du7ipe45vx FOREIGN KEY (task_id) REFERENCES public.tasks(id);


--
-- TOC entry 4054 (class 2606 OID 11571908)
-- Name: contractors_contractor_address fkegicwsjnwwg8lfesc8cl6f40u; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors_contractor_address
    ADD CONSTRAINT fkegicwsjnwwg8lfesc8cl6f40u FOREIGN KEY (contractor_address_id) REFERENCES public.contractor_address(id);


--
-- TOC entry 4080 (class 2606 OID 11572038)
-- Name: request_type fkeqh30f4tt2wmyvpof90wc96ku; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.request_type
    ADD CONSTRAINT fkeqh30f4tt2wmyvpof90wc96ku FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4057 (class 2606 OID 11571923)
-- Name: contractors_email fker6mtkit0uajul3v2rbc80kpk; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors_email
    ADD CONSTRAINT fker6mtkit0uajul3v2rbc80kpk FOREIGN KEY (contractors_id) REFERENCES public.contractors(id);


--
-- TOC entry 4081 (class 2606 OID 11572043)
-- Name: request_type fkeyx2risxcnjcbj3tsexhyejkg; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.request_type
    ADD CONSTRAINT fkeyx2risxcnjcbj3tsexhyejkg FOREIGN KEY (request_type_id) REFERENCES public.request_type(id);


--
-- TOC entry 4053 (class 2606 OID 11571903)
-- Name: contractors fkf0abg48lr5lkm3b0shd3p2e6f; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors
    ADD CONSTRAINT fkf0abg48lr5lkm3b0shd3p2e6f FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4064 (class 2606 OID 11571958)
-- Name: notifications fkg2xy3k6u6j94hi11s1of3fq4c; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.notifications
    ADD CONSTRAINT fkg2xy3k6u6j94hi11s1of3fq4c FOREIGN KEY (contractor_id) REFERENCES public.contractors(id);


--
-- TOC entry 4058 (class 2606 OID 11571928)
-- Name: contractors_passport fkg57s8o5hvdriovgvyb9ksrmpk; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors_passport
    ADD CONSTRAINT fkg57s8o5hvdriovgvyb9ksrmpk FOREIGN KEY (passport_id) REFERENCES public.passport(id);


--
-- TOC entry 4090 (class 2606 OID 11572088)
-- Name: tasks fkg5k5bvcpogfmewrkfm4oanwfm; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT fkg5k5bvcpogfmewrkfm4oanwfm FOREIGN KEY (request_id) REFERENCES public.requests(id);


--
-- TOC entry 4050 (class 2606 OID 11571888)
-- Name: categories fkghuylkwuedgl2qahxjt8g41kb; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT fkghuylkwuedgl2qahxjt8g41kb FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4065 (class 2606 OID 11571963)
-- Name: order_items fkhx6gswhearm3wj5sy50ypcyg5; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT fkhx6gswhearm3wj5sy50ypcyg5 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4072 (class 2606 OID 11571998)
-- Name: passport fkimp0xtvk5mujh4f1bkh7833vx; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.passport
    ADD CONSTRAINT fkimp0xtvk5mujh4f1bkh7833vx FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4077 (class 2606 OID 11572023)
-- Name: request_status_log fkkdrnwwfjff5wfxpocv8whehrg; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.request_status_log
    ADD CONSTRAINT fkkdrnwwfjff5wfxpocv8whehrg FOREIGN KEY (request_id) REFERENCES public.requests(id);


--
-- TOC entry 4056 (class 2606 OID 11571918)
-- Name: contractors_email fkkgpakj4lbko3ndwj3lx1iblct; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors_email
    ADD CONSTRAINT fkkgpakj4lbko3ndwj3lx1iblct FOREIGN KEY (email_id) REFERENCES public.emails(id);


--
-- TOC entry 4073 (class 2606 OID 11572003)
-- Name: phones fkmg6d77tgqfen7n1g763nvsqe3; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.phones
    ADD CONSTRAINT fkmg6d77tgqfen7n1g763nvsqe3 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4060 (class 2606 OID 11571938)
-- Name: contractors_phones fkmtcj02508lid04lndjl0f12rp; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors_phones
    ADD CONSTRAINT fkmtcj02508lid04lndjl0f12rp FOREIGN KEY (phones_id) REFERENCES public.phones(id);


--
-- TOC entry 4076 (class 2606 OID 11572018)
-- Name: request_status_log fkn8q45ebtamom72xeml4md8b8p; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.request_status_log
    ADD CONSTRAINT fkn8q45ebtamom72xeml4md8b8p FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4067 (class 2606 OID 11571973)
-- Name: order_items fkocimc7dtr037rh4ls4l95nlfi; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT fkocimc7dtr037rh4ls4l95nlfi FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- TOC entry 4075 (class 2606 OID 11572013)
-- Name: products fkog2rp4qthbtt2lfyhfo32lsw9; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fkog2rp4qthbtt2lfyhfo32lsw9 FOREIGN KEY (category_id) REFERENCES public.categories(id);


--
-- TOC entry 4086 (class 2606 OID 11572068)
-- Name: requests fkooffbhtd0kk6gtjtds13vwa8q; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.requests
    ADD CONSTRAINT fkooffbhtd0kk6gtjtds13vwa8q FOREIGN KEY (request_status_id) REFERENCES public.request_statuses(id);


--
-- TOC entry 4049 (class 2606 OID 11571883)
-- Name: boards_preset fkpq5rrqp7tweqmnevr199f3lx1; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.boards_preset
    ADD CONSTRAINT fkpq5rrqp7tweqmnevr199f3lx1 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4093 (class 2606 OID 11572103)
-- Name: users fkqg2qcoumch2m4ok1cf8q675yu; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkqg2qcoumch2m4ok1cf8q675yu FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4085 (class 2606 OID 11572063)
-- Name: requests fkqltetgmr11dkqlbx6gidkis4j; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.requests
    ADD CONSTRAINT fkqltetgmr11dkqlbx6gidkis4j FOREIGN KEY (contractor_address_id) REFERENCES public.contractor_address(id);


--
-- TOC entry 4079 (class 2606 OID 11572033)
-- Name: request_statuses fkr4qos82qm71xyip9j3l4c69br; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.request_statuses
    ADD CONSTRAINT fkr4qos82qm71xyip9j3l4c69br FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4059 (class 2606 OID 11571933)
-- Name: contractors_passport fkr6fs7fcro7d7b0icg2odyeg8x; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractors_passport
    ADD CONSTRAINT fkr6fs7fcro7d7b0icg2odyeg8x FOREIGN KEY (person_id) REFERENCES public.contractors(id);


--
-- TOC entry 4071 (class 2606 OID 11571993)
-- Name: orders fkrx2x2huxjmflc8t7an7gmk994; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fkrx2x2huxjmflc8t7an7gmk994 FOREIGN KEY (request_id) REFERENCES public.requests(id);


--
-- TOC entry 4070 (class 2606 OID 11571988)
-- Name: orders fks73ucxrodrjjc1ww4j0097e4x; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fks73ucxrodrjjc1ww4j0097e4x FOREIGN KEY (contractor_address_id) REFERENCES public.contractor_address(id);


--
-- TOC entry 4096 (class 2606 OID 11572118)
-- Name: work_flows fksrx3amvqkxorr69utvei72o92; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.work_flows
    ADD CONSTRAINT fksrx3amvqkxorr69utvei72o92 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4052 (class 2606 OID 11571898)
-- Name: contractor_address fkv7w3ogg1bsrdvl5hjm7ccayq; Type: FK CONSTRAINT; Schema: public; Owner: jxwzhxhe
--

ALTER TABLE ONLY public.contractor_address
    ADD CONSTRAINT fkv7w3ogg1bsrdvl5hjm7ccayq FOREIGN KEY (user_id) REFERENCES public.users(id);


-- Completed on 2022-05-19 20:16:53

--
-- PostgreSQL database dump complete
--

