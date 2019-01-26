# doclets
A simple collection of java 11 doclets

# Introduction

The small repo contains few projects:

- doclet-commons: 


# Javadoc useful concepts

Below you will find some essential concepts for understanind the processing of javadoc (work in progress of course!).

You can document the source code (java files which are not representing modules or packages).
In the source code, you can document
 - classes;
 - methods;
 - fields;
 - constructor;
 - interfaces;

the technical term here is **Doc comments**, which start with `/**` and ends with `*/`:

```
/** doc comment
 *
 */
```

In order to be detected, *doc comments* have to be put before the element you want to document. A *doc comment* is formed by 2 sectors:

 1. main description: start as soon as `/**` is detected and goes until the first block tag is added. The first block tag is detected when you use a block tag at the beginning of the line
 	(e.g., using @param at the beginning of the line);
 2. tag section: start as soon as you use the first block tag and goes until `*/` is detected;


## Tags

Tags are element starting with `@`. There are 2 types of tags:

1. **block tags**: a string preceeded by `@` where `@` appears at the beginning of a *doc comment* row (ignoring `*` characters). The first block tag of a doc comment represents the end of the *main description* sector as well. Block tags starts with the name of the tag (excluded) up until the next block tag (excluded). For example the following doc comment:

```
/**
 * main part
 *
 * @note this is a really interesting note
 * this is also inside the previous note
 *
 * Still in the previous note!
 *
 * @param ok this is a new block tag
 */
```

# Javadoc useful references:

https://doc.bccnsoft.com/docs/jdk7-docs/technotes/tools/solaris/javadoc.html#tagsection
